package com.lzh.dao;

import com.lzh.MyTest;
import com.lzh.bean.NewsComment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class NewsCommentDaoTest extends MyTest {

    @Autowired
    private NewsCommentDao newsCommentDao;


    @Test
    public void findNewsCommentByNewsId() {

        List<NewsComment> newsCommentList = newsCommentDao.findNewsCommentByNewsId(4L);

        for (NewsComment newsComment : newsCommentList) {

            System.out.println(newsComment);
        }

    }

    @Test
    @Transactional
    public void deleteNewsCommentByNewsId() {

        Integer count = newsCommentDao.deleteNewsCommentByNewsId(4L);

        System.out.println(count);

    }

    @Test
    @Transactional
    public void saveNewsCommentByNewsId() {

        NewsComment newsComment = new NewsComment();

        newsComment.setNewsId(2L);
        newsComment.setContent("fhjksdhkshjfgh");
        newsComment.setAuthor("zhangjiang");

        Integer count = newsCommentDao.saveNewsCommentByNewsId(newsComment);

        assertEquals(new Integer(1),count);

    }
}