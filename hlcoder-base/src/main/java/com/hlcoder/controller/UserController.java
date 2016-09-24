package com.hlcoder.controller;

import com.hlcoder.model.User;
import com.hlcoder.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user/userList");
        mv.addObject("userList",userService.getUserInfo());
        return mv;
    }

    @ResponseBody
    public List<User> getUserInfo() {
        List<User> userInfo = userService.getUserInfo();
        System.out.print("123");
        return userInfo;
    }
}
