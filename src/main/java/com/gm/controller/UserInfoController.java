package com.gm.controller;

import com.github.pagehelper.PageInfo;
import com.gm.bean.UserInfo;
import com.gm.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020/2/19 16:19
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;



    //登陆
    @RequestMapping("/doLogin.do")
    public String doLogin(String username, String password, HttpServletRequest request){
        //1、调用service,查询得到结果,自动补全返回值 Ctrl +Alt +V
        UserInfo userInfo = userInfoService.doLogin(username);
        Map<String,String> errors=new HashMap<>();
        String url;
        //2、判断
        if (userInfo!=null){
            if (userInfo.getPassword().equals(password)){
                System.out.println("密码正确，登陆成功");
                HttpSession session=request.getSession();
                session.setAttribute("userInfo",userInfo);
                url="main";
            }else {
                System.out.println("密码错误");
                url="../login";
                errors.put("message","密码错误");
            }
        }else {
            System.out.println("用户不存在");
            url="../login";
            errors.put("message","用户不存在");
        }
        request.setAttribute("errors",errors);
        return url;
    }




    //全部查询
    //所有需要返回数据到页面显示的，都需封装道ModelAndView中
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="5") Integer size){
        //调用service中的方法,得到查询结果
        List<UserInfo> userInfoList = userInfoService.findAll(page,size);

        //把得到的数据存到PageInfo中
        PageInfo pageInfo=new PageInfo(userInfoList);
        System.out.println(pageInfo.getList());
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }


    //增加
    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo){
        //调用service，得到结果
        userInfoService.addUser(userInfo);
        // 增加成功，返回重新查询（重定向）
        return "redirect:findAll.do";
    }


    //删除
    @RequestMapping("/delUser.do")
    public String delUserById(int id){
        userInfoService.delUserById(id);
        System.out.println("删除成功");
        return "redirect:findAll.do";
    }


    //修改前，单个查询
    @RequestMapping("/updSelUserInfoById.do")
    public ModelAndView updSelUserInfoById(int id){
        UserInfo userInfoOne=userInfoService.updSelUserInfoById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("userInfoOne",userInfoOne);
        mv.setViewName("user-update");
        return mv;
    }

    //修改
    @RequestMapping("/updUserInfo.do")
    public String updUserInfo(UserInfo userInfo){
        userInfoService.updUserInfo(userInfo);
        System.out.println("修改成功");
        return "redirect:findAll.do";
    }

    //查询功能
    @RequestMapping("/searUserInfo.do")
    public ModelAndView searUserInfo(String username){
        List<UserInfo> userInfoList = userInfoService.searUserInfo(username);
        PageInfo pageInfo=new PageInfo(userInfoList);
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    //退出
    @RequestMapping("/exit.do")
    public String exit(HttpServletRequest request, SessionStatus sessionStatus){
        HttpSession session=request.getSession();
        session.removeAttribute("userInfo");//我这里是先取出httpsession中的user属性
        session.invalidate();  //然后是让httpsession失效
        sessionStatus.setComplete();//最后是调用sessionStatus方法
        return "../login";
    }



}
