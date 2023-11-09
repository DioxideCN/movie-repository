package cn.dioxide.movierepository.mapper;

import cn.dioxide.movierepository.entity.UserHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dioxide.CN
 * @date 2023/11/9
 * @since 1.0
 */
@Mapper
public interface QueryMapper {

    List<UserHistory> queryUserHistory(@Param("userId") Integer userId);

}
