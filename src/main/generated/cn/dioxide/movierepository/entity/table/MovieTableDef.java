package cn.dioxide.movierepository.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class MovieTableDef extends TableDef {

    /**
     * 映射到数据库中movies表的元组
 @author Dioxide.CN
 @date 2023/11/9
 @since 1.0
     */
    public static final MovieTableDef MOVIE = new MovieTableDef();

    public final QueryColumn TITLE = new QueryColumn(this, "title");

    public final QueryColumn GENRES = new QueryColumn(this, "genres");

    public final QueryColumn MOVIE_ID = new QueryColumn(this, "movieId");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{TITLE, GENRES, MOVIE_ID};

    public MovieTableDef() {
        super("", "movies");
    }

}
