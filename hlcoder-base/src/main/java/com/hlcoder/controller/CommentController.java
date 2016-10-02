package com.hlcoder.controller;

import com.hlcoder.model.Blog;
import com.hlcoder.model.Comment;
import com.hlcoder.service.CommentService;
import com.hlcoder.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by wanghailong on 2016/9/27.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Response add(Comment comment,String vCode,
                                      HttpServletRequest request,
                                      HttpSession session)throws Exception{
        String code=(String) session.getAttribute("vCode");
        if(!vCode.equalsIgnoreCase(code)){
            return new Response().failure("验证码不正确");
        }
        String remoteAddr = request.getRemoteAddr();
        comment.setUserIp(remoteAddr);
        int i = commentService.add(comment);
        if (i==1){
            return new Response();
        }
        return new Response().failure("添加失败");
    }
}
