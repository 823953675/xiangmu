package com.gm.bean;

import java.util.List;

/**
 * 2020/2/19 14:34
 * UserInfo — 实体类，映射数据库字段，字段建议一致
 */
public class UserInfo {
    //为什么要封装？
    //Spring 容器，去访问对象成员属性的时候后必须是封装类型的，不然就没办法访问！

    private int id;         //用户ID
    private String username;//用户名你
    private String password;//用户密码

    private List<Role> roleList;

    //get /sset 访问器


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //构造方法
    public UserInfo() {
    }

    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //toString的方法重写


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
