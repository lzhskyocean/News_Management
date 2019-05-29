package com.lzh.controller;

import com.lzh.bean.NewsComment;
import com.lzh.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lizhenhao
 */

@Controller
@RequestMapping("/comment")
public class NewsCommentController {

    @Autowired
    private NewsCommentService newsCommentService;

    @RequestMapping(value = "/list/{newsId}",method = RequestMethod.GET)
    public String newsCommentList(@PathVariable Long newsId, Model model){


        List<NewsComment> newsCommentList = newsCommentService.findNewsCommentByNewsId(newsId);

        model.addAttribute("newsCommentList",newsCommentList);

        return "/comment_list";

    }

    @RequestMapping(value = "/add")
    public String newsCommentAdd(@Valid NewsComment newsComment,
                                 BindingResult bindingResult,
                                 Long newsId,
                                 Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("newsId",newsId);
            return "/comment_add";
        }

        //newsComment.setNewsId(newsId);
        Integer count = newsCommentService.saveNewsCommentByNewsId(newsComment);
        if (count==1){
            //重定向到评论页面
            return "redirect:/comment/list/"+newsComment.getNewsId();
            //重定向到新闻列表
            //return "redirect:/news/list";

        }



        return "/comment_add";
    }





}
