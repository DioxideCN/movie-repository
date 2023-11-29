package cn.dioxide.movierepository.mapper;

import cn.dioxide.movierepository.entity.Rating;
import cn.dioxide.movierepository.entity.RatingResult;
import cn.dioxide.movierepository.entity.UserHistory;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dioxide.CN
 * @date 2023/11/28
 * @since 1.0
 */
@Mapper
public interface UserHistoryMapper extends BaseMapper<UserHistory> {
    List<UserHistory> userIdSearchPage(Integer userId);
}
