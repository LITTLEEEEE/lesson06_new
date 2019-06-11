package cn.edu.core.model;


import cn.edu.core.app.PageUtil;

import java.util.List;

/**
 * Created by lcy on 16/12/20.
 */
public class CommonPageGridModel implements GridModel {
    private long total;  //总页数

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public long getPageNu() {
        return pageNu;
    }

    public void setPageNu(long pageNo) {
        this.pageNu = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    private List rows ; // 结果集

    private long pageNu; //当前页码

    private long pageSize;

    private long pages;

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public  CommonPageGridModel(PageUtil paginationUtility) {
        total = paginationUtility.getTotal();
        rows = paginationUtility.getList();
        pageNu = paginationUtility.getPageNum();
        pages = paginationUtility.getPages();
    }

    public CommonPageGridModel() {
        total = 0;
    }
    public CommonPageGridModel(long tot, List result, int pageNum, long page) {
        total = tot;
        rows = result;
        pageNu = pageNum;
        pages = page;
    }
}
