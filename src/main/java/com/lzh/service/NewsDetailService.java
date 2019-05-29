package com.lzh.service;

import com.lzh.bean.NewsDetail;
import com.lzh.util.PageInfo;

/**
 * @author lizhenhao
 */

public interface NewsDetailService {

    PageInfo<NewsDetail> findNewsByCondition(String title,Integer page,Integer size);

    boolean deleteNewsDetailAndCommentByNewsId(Long newsId);
}
