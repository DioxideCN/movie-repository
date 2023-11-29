package cn.dioxide.movierepository.entity;

import lombok.Data;

@Data
public class TagResult {
    private Integer movieId;
    private String tagName;
    private String relevance;
}
