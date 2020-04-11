package com.gm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gm.bean.Role;
import com.gm.bean.UserInfo;
import com.gm.dao.IRoleDao;
import com.gm.dao.IUserInfoDao;
import com.gm.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 2020/2/19 15:34
 */
@Service("userService")
public class UserInfoService implements IUserInfoService {
//通过对象名
//    @Resource(name="u1")
//    //通过类名注入
    @Autowired
    private IUserInfoDao userInfoDao;


    @Autowired
    private IRoleDao roleDao;



    @Override
    public UserInfo doLogin(String username) {
        return userInfoDao.doLogin(username);
    }

    //分页查询
    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
//
        PageHelper.startPage(page,size);

        return userInfoDao.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoDao.addUser(userInfo);
    }

    @Override
    public void delUserById(int id) {
        userInfoDao.delUserById(id);
    }

    @Override
    public void updUserInfo(UserInfo userInfo) {
        userInfoDao.updUserInfo(userInfo);
    }

    @Override
    public UserInfo updSelUserInfoById(int id) {
        return userInfoDao.updSelUserInfoById(id);
    }

    @Override
    public List<UserInfo> searUserInfo(String username) {
        return userInfoDao.searUserInfo(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过了UserDetailsServiceImpl");
        //根据姓名查询到当前登陆用户
        UserInfo userInfo = userInfoDao.doLogin(username);
        //根据当前登陆的用户ID，去查询到所属的角色
        List<Role> roleList = roleDao.findRoleByUserId(userInfo.getId());
        userInfo.setRoleList(roleList);
        //得到有效信息后，交给Security处理
        User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(roleList));

        return user;
    }

//    ctrl + alt +b
    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> list=new ArrayList<>();

        for (Role role : roleList){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRname()));
        }
        return list;
    }
}
