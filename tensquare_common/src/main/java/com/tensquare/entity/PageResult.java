package com.tensquare.entity;

import java.util.List;

/**
 * @Description: 分页返回结果
 * @Author: cmj
 * @Date: 2022-03-02 16:35
 * @Version: V1.0
 */
public class PageResult<T> {

    // 总数
    private Long total;
    // 结果集
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
