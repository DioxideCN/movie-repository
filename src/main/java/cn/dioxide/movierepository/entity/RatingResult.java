package cn.dioxide.movierepository.entity;

import com.mybatisflex.core.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data(staticConstructor = "create")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class RatingResult extends Model<RatingResult> {

    private Integer movieId;

    private String title;

    private Double rating;

    private String timestamp;

}
