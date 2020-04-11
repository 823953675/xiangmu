package com.gm.controller;

import com.github.pagehelper.PageInfo;
import com.gm.bean.Role;
import com.gm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 2020/3/3 15:04
 */
@Controller
@RequestMapping("/role")    //restFul webService 代码风格
public class RoleController {

    @Autowired
    IRoleService roleService;

    //分页查询
    @RequestMapping("/findAllRole.do")
    public ModelAndView findAllRole(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer size){

        List<Role> roleList = roleService.findAllRole(page, size);
        //创建出分页中的内置对象，将查询到的List传到对象中
        PageInfo pageInfo=new PageInfo(roleList);

        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");

        return mv;
    }


    //增加角色
    @RequestMapping("/addRole.do")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:findAllRole.do";
    }

    //删除角色
    @RequestMapping("/delRoleById.do")
    public String delRoleById(int id){
        roleService.delRoleById(id);
        return "redirect:findAllRole.do";
    }

    //修改前，单个查询
    @RequestMapping("/updSelRoleById.do")
    public ModelAndView updSelRoleById(int id){
        Role roleOne=roleService.updSelRoleById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("roleOne",roleOne);
        mv.setViewName("role-update");
        return mv;
    }


    //修改
    @RequestMapping("/updRole.do")
    public String updUserInfo(Role role){
        roleService.updRole(role);
        System.out.println("修改成功");
        return "redirect:findAllRole.do";
    }

}
