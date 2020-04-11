package com.gm.service;

import com.gm.bean.Role;

import java.util.List;

/**
 * 2020/3/3 14:54
 * 业务逻辑层
 */
public interface IRoleService {

    List<Role> findAllRole(Integer page,Integer size);

    void addRole(Role role);

    void delRoleById(int id);

    void updRole(Role role);

    //单个查询
    Role updSelRoleById(int id);

}
