package com.hlcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanghailong on 16/9/7.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin() {
        System.out.print("登录页....");
        return "admin/login";
    }

    @RequestMapping(value = "/admin/index",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/index");
        mv.addObject("test","123124312");
        System.out.print("登录中.....");
        return mv;
    }


}
