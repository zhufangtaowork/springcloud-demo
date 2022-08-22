package com.xz.entity.commonview;

import lombok.Data;

/**
 * @ClassName： ResultPageView
 * @Description： TODO
 * @Date： 2020/8/10 10:32 上午
 * @author： ZhuFangTao
 */
@Data
public  class ResultPageView<T> extends ResultView<T>{

    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private Integer maxPage;


    public  ResultPageView<T> setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public  ResultPageView<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public  ResultPageView<T> setTotal(Long total) {
        this.total = total;
        return this;
    }

    public  ResultPageView<T> setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
        return this;
    }

    @Override
    public ResultPageView<T> setMsgCode(String code) {
        super.setMsgCode(code);
        return this;
    }

    @Override
    public void setCode(String code) {
        super.setCode(code);
    }

    @Override
    public void setMsg(String msg) {
        super.setMsg(msg);
    }

    @Override
    public ResultPageView<T> setData(T data) {
        super.setData(data);
        return this;
    }
}
