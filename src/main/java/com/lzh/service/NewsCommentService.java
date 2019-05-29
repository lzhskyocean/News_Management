package com.lzh.service;

import com.lzh.bean.NewsComment;

import java.util.List;

/**
 * @author lizhenhao
 */
public interface NewsCommentService {

    //通过newsId查询对应的所评论
    List<NewsComment> findNewsCommentByNewsId(Long newsId);


    Integer saveNewsCommentByNewsId(NewsComment newsComment);
}
