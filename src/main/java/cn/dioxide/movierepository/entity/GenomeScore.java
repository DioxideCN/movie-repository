package cn.dioxide.movierepository.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Dioxide.CN
 * @date 2023/11/9
 * @since 1.0
 */
@Data
@Table("genome-scores")
public class GenomeScore {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    @Column("movieId")
    private Integer movieId;

    @Column("tagId")
    private Integer tagId;

    BigDecimal relevance;

}
