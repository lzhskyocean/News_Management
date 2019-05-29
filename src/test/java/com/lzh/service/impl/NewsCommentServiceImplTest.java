package com.lzh.service.impl;

import com.lzh.MyTest;
import com.lzh.bean.NewsComment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class NewsCommentServiceImplTest extends MyTest {

    @Autowired
    private NewsCommentServiceImpl newsCommentServiceImpl;

    @Test
    public void findNewsCommentByNewsId() {

        List<NewsComment> newsCommentList = newsCommentServiceImpl.findNewsCommentByNewsId(4L);

        for (NewsComment newsComment : newsCommentList) {

            System.out.println(newsComment);
        }
    }
}