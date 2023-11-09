package cn.dioxide.movierepository;

import cn.dioxide.movierepository.entity.UserHistory;
import cn.dioxide.movierepository.mapper.QueryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieRepositoryApplicationTests {

    @Autowired
    private QueryMapper queryMapper;

    @Test
    void contextLoads() {
        List<UserHistory> userHistories = queryMapper.queryUserHistory(65);
        userHistories.forEach(System.out::println);
    }

}
