package cn.dioxide.movierepository.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 映射到数据库中movies表的元组
 * @author Dioxide.CN
 * @date 2023/11/9
 * @since 1.0
 */
@Data
@Table("movies")
public class Movie {

    @Id(keyType = KeyType.Auto)
    @Column("movieId")
    private Integer movieId;

    private String title;

    private String genres;

}
