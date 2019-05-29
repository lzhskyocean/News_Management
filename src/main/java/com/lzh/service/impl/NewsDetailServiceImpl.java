package com.lzh.service.impl;

import com.lzh.bean.NewsDetail;
import com.lzh.dao.NewsCommentDao;
import com.lzh.dao.NewsDetailDao;
import com.lzh.service.NewsDetailService;
import com.lzh.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenhao
 */

@Service
public class NewsDetailServiceImpl implements NewsDetailService {

    @Autowired
    private NewsDetailDao newsDetailDao;

    @Autowired
    private NewsCommentDao newsCommentDao;

    @Override
    public PageInfo<NewsDetail> findNewsByCondition(String title, Integer page, Integer size) {

        //查询新闻总数
        Integer count = newsDetailDao.findCountNewsByLikeTitle(title);

        //创建页面信息
        PageInfo<NewsDetail> pageInfo = new PageInfo<>(page, size, count);

        //查询新闻
        List<NewsDetail> list = newsDetailDao.findByLikePage(title, pageInfo.getOffset(), size);

        pageInfo.setList(list);

        return pageInfo;
    }

    @Override
    public boolean deleteNewsDetailAndCommentByNewsId(Long newsId) {

        Integer count = newsDetailDao.deleteNewsDetailByNewsId(newsId);

        if (count==1){
            Integer count2 = newsCommentDao.deleteNewsCommentByNewsId(newsId);

            if (count2>0){//多条
                return true;
            }
        }

        return false;
    }
}
