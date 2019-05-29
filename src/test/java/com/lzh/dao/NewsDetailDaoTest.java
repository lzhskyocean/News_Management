package com.lzh.dao;

import com.lzh.MyTest;
import com.lzh.bean.NewsDetail;
import org.junit.Test;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class NewsDetailDaoTest extends MyTest {

    @Autowired
    private NewsDetailDao newsDetailDao;

    @Test
    public void findByLikePage() {

        List<NewsDetail> newsDetailList = newsDetailDao.findByLikePage("", 0, 2);

        for (NewsDetail newsDetail : newsDetailList) {

            System.out.println(newsDetail);

        }


    }

    @Test
    public void findCountNewsByLikeTitle() {

        Integer count = newsDetailDao.findCountNewsByLikeTitle("火");

        System.out.println(count);
    }
}