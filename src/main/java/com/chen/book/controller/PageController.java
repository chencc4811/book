package com.chen.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("to")
public class PageController {

    @RequestMapping("test")
    public String test(){
        return "userinfo";
    }
    @RequestMapping("adminadduser")
    public String test9(){
        return "admin/adduser";
    }


    @RequestMapping("adminaddadmin")
    public String test11(){
        return "admin/addadmin";
    }


    @RequestMapping("upload")
    public String test1(){
        return "upload";
    }
    @RequestMapping("register")
    public String test2(){
        return "register";
    }
    @RequestMapping("login")
    public String test3(){
        return "login";
    }


    @RequestMapping("adminlogin")
    public String test10(){
        return "admin/login";
    }

    @RequestMapping("index")
    public String test4(){
        return "index";
    }

    @RequestMapping("comment")
    public String test6(){
        return "comment";
    }

    @RequestMapping("adminindex")
    public String test7(){
        return "admin/index";
    }
    @RequestMapping("memberlist")
    public String test8(){
        return "admin/member-list";
    }


}
