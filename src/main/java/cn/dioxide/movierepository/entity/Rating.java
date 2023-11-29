package cn.dioxide.movierepository.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("ratings")
public class Rating {

    @Id(keyType = KeyType.Auto)
    @Column(value = "id")
    private Integer id;

    @Column("userId")
    private Integer userId;

    @Column("movieId")
    private Integer movieId;

    @Column("rating")
    private Double rating;

    @Column("timestamp")
    private Long timestamp;

}
