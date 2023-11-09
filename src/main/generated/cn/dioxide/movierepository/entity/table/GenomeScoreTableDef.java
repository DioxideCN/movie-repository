package cn.dioxide.movierepository.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class GenomeScoreTableDef extends TableDef {

    /**
     * @author Dioxide.CN
 @date 2023/11/9
 @since 1.0
     */
    public static final GenomeScoreTableDef GENOME_SCORE = new GenomeScoreTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn TAG_ID = new QueryColumn(this, "tagId");

    public final QueryColumn MOVIE_ID = new QueryColumn(this, "movieId");

    public final QueryColumn RELEVANCE = new QueryColumn(this, "relevance");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, TAG_ID, MOVIE_ID, RELEVANCE};

    public GenomeScoreTableDef() {
        super("", "genome-scores");
    }

}
