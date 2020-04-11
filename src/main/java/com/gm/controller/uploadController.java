package com.gm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 2020/3/12 11:30
 */
@Controller
@RequestMapping("/uploadController")
public class uploadController {

    private static final String UPLOAD_PATH = "E:/蒋SSM/upload";



    //如何实现参数的封装 :   上传的时候，如何给出判断或者验证
    //需要：CommonsMultipartResolver,配置springMVC容器
    @RequestMapping("/upload.do")
    public ModelAndView upload(@RequestParam("myPic") MultipartFile myPic) throws IOException {

        //1、文件在服务器上的存储
        //先生成新得分文件名
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        UUID rid = UUID.randomUUID();
        String uid=df.format(new Date())+rid.getLeastSignificantBits();


        // File file= new File(文件地址+文件名+加后缀);//    http://a0.att.hudong.com/27/10/01300000324235124757108108752.jpg

        //取出后缀名，进行字符串拼接
        String filename=myPic.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf('.'));

        System.out.println(UPLOAD_PATH+ "/" +uid+suffix);
        File file= new File(UPLOAD_PATH+ "/" +uid+suffix);

        //throws 和 try...catch 有什么区别
        //throws抛异常不会执行后面代码，另一个相反
        myPic.transferTo(file);


        //2、文件地址的回显
        ModelAndView mv=new ModelAndView();
        mv.setViewName("upload");
        mv.addObject("upload_file_path",file.getName());
        //3、给出页面跳转

        return mv;
    }
}
