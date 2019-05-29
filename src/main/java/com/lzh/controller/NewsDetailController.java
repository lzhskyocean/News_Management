package com.lzh.controller;

import com.lzh.bean.NewsDetail;
import com.lzh.service.NewsDetailService;
import com.lzh.util.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lizhenhao
 */

@Controller
@RequestMapping("/news")
public class NewsDetailController {

    @Autowired
    private NewsDetailService newsDetailService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                       @RequestParam(value = "size",defaultValue = "2") Integer size,
                       String title,
                       Model model
    ){

        PageInfo<NewsDetail> pageInfo = newsDetailService.findNewsByCondition(title, page, size);

        model.addAttribute("pageInfo",pageInfo);

        model.addAttribute("title",title);

        return "/news_list";
    }

    @RequestMapping("/delete/{newsId}")
    @ResponseBody
    public Boolean newsDelete(@PathVariable Long newsId){

        boolean b = newsDetailService.deleteNewsDetailAndCommentByNewsId(newsId);

        return b;
    }


}
