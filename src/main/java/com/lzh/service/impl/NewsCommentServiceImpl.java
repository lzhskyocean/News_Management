package com.lzh.service.impl;

import com.lzh.bean.NewsComment;
import com.lzh.dao.NewsCommentDao;
import com.lzh.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenhao
 */

@Service
public class NewsCommentServiceImpl implements NewsCommentService {

    @Autowired
    private NewsCommentDao newsCommentDao;

    @Override
    public List<NewsComment> findNewsCommentByNewsId(Long newsId) {

        return newsCommentDao.findNewsCommentByNewsId(newsId);
    }

    @Override
    public Integer saveNewsCommentByNewsId(NewsComment newsComment) {

        return newsCommentDao.saveNewsCommentByNewsId(newsComment);

    }
}
