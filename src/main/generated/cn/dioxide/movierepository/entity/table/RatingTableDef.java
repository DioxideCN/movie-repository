package cn.dioxide.movierepository.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class RatingTableDef extends TableDef {

    public static final RatingTableDef RATING = new RatingTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn RATING_ = new QueryColumn(this, "rating");

    public final QueryColumn USER_ID = new QueryColumn(this, "userId");

    public final QueryColumn MOVIE_ID = new QueryColumn(this, "movieId");

    public final QueryColumn TIMESTAMP = new QueryColumn(this, "timestamp");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, RATING_, USER_ID, MOVIE_ID, TIMESTAMP};

    public RatingTableDef() {
        super("", "ratings");
    }

}
