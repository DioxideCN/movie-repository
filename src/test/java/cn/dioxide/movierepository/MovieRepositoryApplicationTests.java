package cn.dioxide.movierepository;

import cn.dioxide.movierepository.entity.TagResult;
import cn.dioxide.movierepository.entity.UserHistory;
import cn.dioxide.movierepository.mapper.TagResultMapper;
import cn.dioxide.movierepository.mapper.UserHistoryMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryTable;
import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class MovieRepositoryApplicationTests {

    @Autowired
    private UserHistoryMapper userHistoryMapper;

    @Autowired
    private TagResultMapper tagResultMapper;

    @Test
    void contextLoads() {
        Page<UserHistory> paginate = userHistoryMapper.paginate(
                1,
                10,
                QueryWrapper.create()
                        .select(
                                "movies.movieId",
                                "movies.title",
                                "ratings.rating",
                                "ratings.timestamp")
                        .from("ratings")
                        .innerJoin("movies").on("ratings.movieId = movies.movieId")
                        .eq("userId", 65)
                        .orderBy("timestamp DESC")
        );
        List<UserHistory> userHistories = paginate.getRecords();
        // movieIds分组
        Map<Integer, List<Integer>> groupedMovieIds = userHistories.stream()
                .collect(Collectors.groupingBy(history -> history.getMovieId() % 10,
                        Collectors.mapping(UserHistory::getMovieId, Collectors.toList())));
        Map<Integer, List<TagResult>> tagResults = groupedMovieIds.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Integer> movieIds = entry.getValue();
                            QueryWrapper wrapper = QueryWrapper.create()
                                    .select(new QueryColumn("gs", "relevance").as("relevance"),
                                            new QueryColumn("gs", "movieId").as("movieId"),
                                            new QueryColumn("genome-tags", "tag").as("tagName"))
                                    .from(new QueryTable("genome-scores_" + entry.getKey()).as("gs"),
                                            new QueryTable("genome-tags").as("gt"))
                                    .where("gs.tagId = gt.tagId");
                            // AND
                            if (!movieIds.isEmpty()) {
                                wrapper.and("gs.movieId = " + movieIds.get(0));
                            }
                            // OR
                            for (int i = 1; i < movieIds.size(); i++) {
                                wrapper.or("gs.movieId = " + movieIds.get(i));
                            }
                            wrapper.orderBy("gs.relevance DESC").limit(3);
                            return tagResultMapper.selectListByQuery(wrapper);
                        }
                ));
        for (UserHistory history : userHistories) {
            Integer movieId = history.getMovieId();
            tagResults.get(movieId % 10).forEach(tag -> {
                if (tag.getMovieId().equals(movieId)) {
                    history.getRelevance().add(tag);
                }
            });
            System.out.println(history);
        }
    }

}
