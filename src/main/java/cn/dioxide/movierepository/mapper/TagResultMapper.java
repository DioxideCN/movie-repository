package cn.dioxide.movierepository.mapper;

import cn.dioxide.movierepository.entity.RatingResult;
import cn.dioxide.movierepository.entity.TagResult;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dioxide.CN
 * @date 2023/11/28
 * @since 1.0
 */
@Mapper
public interface TagResultMapper extends BaseMapper<TagResult> {
}
