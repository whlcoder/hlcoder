package com.hlcoder.controller;

import com.hlcoder.model.Blog;
import com.hlcoder.model.BlogType;
import com.hlcoder.model.Blogger;
import com.hlcoder.model.PageBean;
import com.hlcoder.service.BlogService;
import com.hlcoder.service.BlogTypeService;
import com.hlcoder.service.BloggerService;
import com.hlcoder.util.PageUtil;
import com.hlcoder.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页
 * Created by wanghailong on 16/9/7.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private BlogService blogService;
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private BloggerService bloggerService;

    private String bloggerName = "路依然遥远";

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mav=new ModelAndView();
        Blogger blogger = bloggerService.getByUserName(bloggerName);
        mav.addObject("blogger",blogger);
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value = {"index"})
    public ModelAndView index(@RequestParam(value="page",required=false)String page,
                              @RequestParam(value="typeId",required=false)String typeId)throws Exception{
        ModelAndView mav=new ModelAndView();
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),10);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("typeId", typeId);
        List<Blog> blogList=blogService.list(map);
        mav.addObject("blogList", blogList);
        Blogger blogger = bloggerService.getByUserName(bloggerName);
        mav.addObject("blogger",blogger);
        List<BlogType> blogTypeCountList=blogTypeService.countList(); // 查询博客类别以及博客的数量
        mav.addObject("blogTypeList",blogTypeCountList);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = {"/blogType"})
    public ModelAndView blogType(@RequestParam(value="typeId",required=false)String typeId)throws Exception{
        ModelAndView mav=new ModelAndView();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("typeId", typeId);
        List<Blog> blogList=blogService.list(map);
        mav.addObject("blogList", blogList);
        mav.setViewName("content");
        return mav;
    }

    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    public ModelAndView article(@PathVariable("id")int id)throws Exception{
        ModelAndView mav=new ModelAndView();
        Blog blog=blogService.findById(id);
        mav.addObject("blog", blog);
        mav.setViewName("article");
        return mav;
    }

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public ModelAndView about()throws Exception{
        ModelAndView mav=new ModelAndView();
        Blogger blogger = bloggerService.getByUserName(bloggerName);
        mav.addObject("blogger",blogger);
        mav.setViewName("about");
        return mav;
    }
}
