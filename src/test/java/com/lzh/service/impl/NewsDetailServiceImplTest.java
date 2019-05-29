package com.lzh.service.impl;

import com.lzh.MyTest;
import com.lzh.bean.NewsDetail;
import com.lzh.service.NewsDetailService;
import com.lzh.util.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class NewsDetailServiceImplTest extends MyTest {

    @Autowired
    private NewsDetailServiceImpl newsDetailServiceImpl;

    @Test
    public void findNewsByCondition() {


        PageInfo<NewsDetail> pageInfo = newsDetailServiceImpl.findNewsByCondition("", 1, 2);

        System.out.println(pageInfo);


    }
}