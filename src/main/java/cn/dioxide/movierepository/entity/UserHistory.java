package cn.dioxide.movierepository.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Dioxide.CN
 * @date 2023/11/28
 * @since 1.0
 */
@Data
public class UserHistory {

    private Integer movieId;      // 电影ID 映射自movies

    private String title;         // 电影标题 映射自movies

    private Integer rating;       // 电影评分 映射自movies

    private Long timestamp;       // 观影时间 映射自rating

    private String tag;           // 电影前三个标签 映射自genome-tags与tags联表

    private List<TagResult> relevance = new ArrayList<>(); // 关联度 映射自genome-scores

}
