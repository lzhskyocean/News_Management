package com.lzh.dao;

import com.lzh.bean.NewsDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhenhao
 */

public interface NewsDetailDao {

    //分页查询新闻
    List<NewsDetail> findByLikePage(@Param("title") String title,
                                    @Param("offset") Integer offset,
                                    @Param("size") Integer size
                                     );

    //通过查询总数
    Integer findCountNewsByLikeTitle(@Param("title") String title);

    //根据NewsId删除新闻
    Integer deleteNewsDetailByNewsId(@Param("newsId") Long newsId);
}
