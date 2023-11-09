package cn.dioxide.movierepository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.dioxide.movierepository.mapper")
public class MovieRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRepositoryApplication.class, args);
    }

}
