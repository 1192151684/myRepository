package com.sam.wms.common.pageutils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 * date:2021.03.2021/3/8
 * time:9:29
 */
public class Page {

    private boolean hasPreviousPage;

    private boolean hasNextPage;

    private int totalCount; // 总记录数

    private int totalPageCount; // 总页数

    private int currentPage = 1; // 当前第几页

    private int pageSize = 5; // 每页记录数

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}


