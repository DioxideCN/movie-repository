package cn.dioxide.movierepository.service;

import cn.dioxide.movierepository.entity.UserHistory;
import cn.dioxide.movierepository.infra.PageResult;
import cn.dioxide.movierepository.mapper.TagResultMapper;
import cn.dioxide.movierepository.mapper.UserHistoryMapper;
import cn.dioxide.movierepository.service.impl.IRatingDefinitionService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryTable;
import com.mybatisflex.core.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 采用异步并行流优化
 * @author Dioxide.CN
 * @date 2023/11/28
 * @since 1.0
 */
@Service
public class RatingDefinitionService implements IRatingDefinitionService {

    @Resource
    UserHistoryMapper userHistoryMapper;

    @Resource
    TagResultMapper tagResultMapper;

    @Override
    public Mono<PageResult<?>> ratingResultSearch(Integer id,
                                                  Integer page,
                                                  Integer size) {
        Page<UserHistory> paginate = userHistoryMapper.paginate(
                page, size,
                QueryWrapper.create()
                        .select("movies.movieId", "movies.title", "ratings.rating", "ratings.timestamp")
                        .from("ratings")
                        .innerJoin("movies").on("ratings.movieId = movies.movieId")
                        .eq("userId", id)
                        .orderBy("timestamp DESC")
        );
        List<UserHistory> userHistories = paginate.getRecords();
        // 并行流movieIds分组
        Map<Integer, List<Integer>> groupedMovieIds = userHistories.parallelStream()
                .collect(Collectors.groupingBy(history -> history.getMovieId() % 10,
                         Collectors.mapping(UserHistory::getMovieId, Collectors.toList())));
        // 异步查询tagResults
        Flux<UserHistory> updatedUserHistoriesFlux = Flux.fromIterable(userHistories)
                .flatMap(history -> {
                    int movieId = history.getMovieId();
                    List<Integer> movieIds = groupedMovieIds.get(movieId % 10);
                    QueryWrapper wrapper = QueryWrapper.create()
                            .select("gs.relevance AS relevance", "gs.movieId AS movieId", "gt.tag AS tagName")
                            .from(new QueryTable("genome-scores_" + movieId % 10).as("gs"),
                                    new QueryTable("genome-tags").as("gt"))
                            .where("gs.tagId = gt.tagId")
                            .in("gs.movieId", movieIds.toArray())
                            .orderBy("gs.relevance DESC").limit(3);
                    return Mono.fromCallable(() -> tagResultMapper.selectListByQuery(wrapper))
                            .map(tagList -> {
                                tagList.stream()
                                        .filter(tag -> tag.getMovieId().equals(movieId))
                                        .forEach(history.getRelevance()::add);
                                return history;
                            });
                });
        // 等待异步任务
        return Mono.when(updatedUserHistoriesFlux)
                .then(Mono.just(PageResult.of(userHistories, paginate)));
    }

}
