package com.gm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gm.bean.Role;
import com.gm.dao.IRoleDao;
import com.gm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2020/3/3 14:56
 */

//@Controller
//@Component
//@Repository

@Service
public class RoleServiceImpl implements IRoleService {

//    @Resource 每次使用需要备注名字，太麻烦
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAllRole(Integer page, Integer size) {
        PageHelper.startPage(page,size);

        return roleDao.findAllRole();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void delRoleById(int id) {
        roleDao.delRoleById(id);
    }

    @Override
    public void updRole(Role role) {
        roleDao.updRole(role);
        System.out.println("rolerole");
    }

    @Override
    public Role updSelRoleById(int id) {
        return roleDao.updSelRoleById(id);
    }


}
