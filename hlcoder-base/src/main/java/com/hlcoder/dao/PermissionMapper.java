package com.hlcoder.dao;

import java.util.Set;

/**
 * Created by wanghailong on 16/9/5.
 */
public interface PermissionMapper {
    public Set<String> getPermissionNames(int roleId);
}
