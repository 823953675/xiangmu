package com.gm.dao;

import com.gm.bean.Role;

import java.util.List;

/**
 * 2020/3/3 14:49
 * 数据库交互层
 */
public interface IRoleDao {

    //查询全部角色
    List<Role> findAllRole();

    //角色新增
    void addRole(Role role);

    //角色删除
    void delRoleById(int id);

    //单个查询
    Role updSelRoleById(int id);

    //修改
    void updRole(Role role);

    //根据用户ID去查询role角色
    List<Role> findRoleByUserId(int rid);



}
