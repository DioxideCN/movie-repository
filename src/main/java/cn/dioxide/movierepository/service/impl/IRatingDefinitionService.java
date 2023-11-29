package cn.dioxide.movierepository.service.impl;

import cn.dioxide.movierepository.entity.RatingResult;
import cn.dioxide.movierepository.infra.PageResult;
import com.mybatisflex.core.paginate.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Dioxide.CN
 * @date 2023/11/28
 * @since 1.0
 */
@Service
public interface IRatingDefinitionService {
    Mono<PageResult<?>> ratingResultSearch(Integer id,
                                           Integer page);
}
