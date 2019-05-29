package com.lzh.dao;

import com.lzh.bean.NewsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhenhao
 */
public interface NewsCommentDao {

    //通过newsId查询对应的所评论
    List<NewsComment> findNewsCommentByNewsId(@Param("newsId") Long newsId);

    //添加评论
    Integer saveNewsCommentByNewsId(NewsComment newsComment);

    //通过newsId删除评论
    Integer deleteNewsCommentByNewsId(@Param("newsId") Long newsId);


}
