package cn.edu.core.app;


import cn.edu.core.model.CommonPageGridModel;
import cn.edu.core.model.GridModel;
import cn.edu.core.model.PageInfo;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.Serializable;
import java.util.List;

/**
 * @descript page component
 * @author cy
 * Created by cy on 16/5/20.
 */
@Aspect
@Slf4j
public class PageUtil<T> extends PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 8730332880750989562L;
    private GridModel gridModel;

    public GridModel getGridModel() {
        return gridModel;
    }

    public void setGridModel(GridModel gridModel) {
        this.gridModel = gridModel;
    }

    public PageUtil() {

    }


    private void setPageInfo(PageUtil<T> paginationUtility, PageInfo<T> pageInfo) {
        paginationUtility.setEndRow(pageInfo.getEndRow());
        paginationUtility.setFirstPage(pageInfo.getFirstPage());
        paginationUtility.setHasNextPage(pageInfo.isHasNextPage());
        paginationUtility.setHasPreviousPage(pageInfo.isHasPreviousPage());
        paginationUtility.setIsFirstPage(pageInfo.isIsFirstPage());
        paginationUtility.setIsLastPage(pageInfo.isIsLastPage());
        paginationUtility.setLastPage(pageInfo.getLastPage());
        paginationUtility.setNavigatepageNums(pageInfo.getNavigatepageNums());
        paginationUtility.setNavigatePages(pageInfo.getNavigatePages());
        paginationUtility.setNextPage(pageInfo.getNextPage());
        paginationUtility.setOrderBy(pageInfo.getOrderBy());
        paginationUtility.setPageNum(pageInfo.getPageNum());
        paginationUtility.setPages(pageInfo.getPages());
        paginationUtility.setPageSize(pageInfo.getPageSize());
        paginationUtility.setPrePage(pageInfo.getPrePage());
        paginationUtility.setSize(pageInfo.getSize());
        paginationUtility.setStartRow(pageInfo.getStartRow());
        paginationUtility.setList(pageInfo.getList());
        paginationUtility.setTotal(pageInfo.getTotal());
        paginationUtility.setGridModel(new CommonPageGridModel(paginationUtility));
    }

    /**
     * 环绕aop   service.*ByPagination    分页拦截
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* cn.edu..*.service.impl.*ServiceImpl.*ByPagination(..))")
    public List<T> preparedPageHeplerAndloadingPageInfoSetResults(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        PageUtil paginationUtility = (PageUtil)proceedingJoinPoint.getArgs()[0];
        PageHelper.startPage(paginationUtility.getPageNum(), paginationUtility.getPageSize(), paginationUtility.getOrderBy());
        try {
            List e = (List)proceedingJoinPoint.proceed();
            PageInfo pageInfo = new PageInfo(e);
            this.setPageInfo(paginationUtility, pageInfo);
            return e;
        } catch (Throwable var5) {
            log.error(var5.getMessage());
            throw var5;
        }
    }

    public List<T> getList() {
        return super.getList();
    }



}
