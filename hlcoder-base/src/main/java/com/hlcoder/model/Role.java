package com.hlcoder.model;

import java.util.List;

/**
 * Created by wanghailong on 16/9/3.
 */
public class Role {
    private Integer id;
    private String roleName;
    private List<Permission> permissionList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
