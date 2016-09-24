package com.hlcoder.service;

import com.hlcoder.dao.UserMapper;
import com.hlcoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public List<User> getUserInfo(){
        List<User> userInfo = userDao.findUserInfo();
        return userInfo;
    }

}
