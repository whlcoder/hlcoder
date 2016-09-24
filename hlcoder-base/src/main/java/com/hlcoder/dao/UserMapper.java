package com.hlcoder.dao;


import com.hlcoder.model.Role;
import com.hlcoder.model.User;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    public List<User> findUserInfo();
    public User findByName(String name);
    public Set<String> getRolesName(String name);
    public Set<Role> getRoles(String name);
}
