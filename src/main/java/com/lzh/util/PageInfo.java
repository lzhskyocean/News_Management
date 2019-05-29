package com.lzh.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lizhenhao
 */


@Data
@NoArgsConstructor
public class PageInfo<T> {

    //当前页
    private Integer page;
    //页容量
    private Integer size;
    //总条数(查询)
    private Integer count;
    //起始位置(计算)
    private Integer offset;
    //总页数(计算)
    private Integer pages;
    //每页的对应的查询结果(查询)
    private List<T> list;


    public PageInfo(Integer page, Integer size, Integer count) {
        this.page = page < 1 ? 1 : page;
        this.size = size < 1 ? 2 : size;
        this.count = count;
        this.offset = (this.page - 1) * this.size;
        this.pages = (int) Math.ceil(count * 1.0 / this.size);
    }
}
