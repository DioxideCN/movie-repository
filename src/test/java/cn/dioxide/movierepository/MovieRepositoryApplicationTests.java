package cn.dioxide.movierepository;

import cn.dioxide.movierepository.entity.Movie;
import cn.dioxide.movierepository.mapper.MovieMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieRepositoryApplicationTests {

    @Autowired
    private MovieMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.selectOneById(1));
    }

}
