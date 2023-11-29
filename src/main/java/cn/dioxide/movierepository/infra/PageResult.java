package cn.dioxide.movierepository.infra;

import com.mybatisflex.core.paginate.Page;
import lombok.Data;

import java.util.List;

/**
 * @author Dioxide.CN
 * @date 2023/11/29
 * @since 1.0
 */
@Data
public class PageResult<T> {

    private final List<T> results;

    private final Long pageNumber, pageSize, totalPage, totalRow;

    private PageResult(List<T> results, Page<?> page) {
        this.results = results;
        this.pageNumber = page.getPageNumber();
        this.pageSize = page.getPageSize();
        this.totalPage = page.getTotalPage();
        this.totalRow = page.getTotalRow();
    }

    public static <U> PageResult<U> of(List<U> results, Page<?> page) {
        return new PageResult<>(results, page);
    }

}
