package cn.dioxide.movierepository.router;

import cn.dioxide.movierepository.entity.RatingResult;
import cn.dioxide.movierepository.infra.PageResult;
import cn.dioxide.movierepository.service.impl.IRatingDefinitionService;
import com.mybatisflex.core.paginate.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Dioxide.CN
 * @date 2023/11/28
 * @since 1.0
 */
@Controller
@RestController
@RequestMapping("/api/v1alpha")
@CrossOrigin
public class DefaultRouter {

    @Resource
    IRatingDefinitionService service;

    @RequestMapping("/rating")
    public Mono<PageResult<?>> ratingResultSearch(@RequestParam Integer id,
                                                  @RequestParam(required = false,defaultValue = "1") Integer page) {
        return service.ratingResultSearch(id, page);
    }

}
