package com.gm.dao;

import com.gm.bean.UserInfo;

import javax.xml.registry.infomodel.User;
import java.util.List;

/**
 * 2020/2/19 14:43
 * IUserInfoDao — 接口，数据库访问层，直接可以访问数据库
 */
public interface IUserInfoDao {

    //验证登陆
    //查询 Select
    UserInfo doLogin(String username);

    //全部查询
    List<UserInfo> findAll();

    //增加
    void  addUser(UserInfo userInfo);

    //删除，根据主键ID
    void delUserById(int id);

    //修改
    void updUserInfo(UserInfo userInfo);

    //单个查询
    UserInfo updSelUserInfoById(int id);

    //搜索功能，通过姓名查询
    List<UserInfo> searUserInfo(String username);


}
