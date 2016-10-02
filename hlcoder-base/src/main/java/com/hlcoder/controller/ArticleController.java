package com.hlcoder.controller;

import com.hlcoder.model.Blog;
import com.hlcoder.model.Comment;
import com.hlcoder.service.BlogService;
import com.hlcoder.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghailong on 2016/9/28.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private BlogService blogService;
    @Resource
    private CommentService commentService;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView article(@PathVariable("id")int id)throws Exception{
        ModelAndView mav=new ModelAndView();
        Blog blog=blogService.findById(id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("blogId",id);
        List<Comment> list = commentService.list(map);
        blog.setClickHit(blog.getClickHit()+1);
        blogService.update(blog);
        blog.setCommentList(list);
        mav.addObject("blog", blog);
        mav.addObject("commentList",list);
        mav.addObject("lastBlog",blogService.getLastBlog(id));
        mav.addObject("nextBlog",blogService.getNextBlog(id));
        mav.setViewName("article");
        return mav;
    }
}
