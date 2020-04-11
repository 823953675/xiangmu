package com.gm.service;

import com.gm.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 2020/2/19 15:31
 * IUserInfoService — 业务逻辑层
 */
public interface IUserInfoService extends UserDetailsService {

    UserInfo doLogin(String username);

    List<UserInfo> findAll(Integer page, Integer size);

    void  addUser(UserInfo userInfo);

    void delUserById(int id);

    void updUserInfo(UserInfo userInfo);

    UserInfo updSelUserInfoById(int id);

    List<UserInfo> searUserInfo(String username);


}
