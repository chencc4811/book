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
    @RequestMapping("index")
    public String test4(){
        return "index";
    }

    @RequestMapping("comment")
    public String test6(){
        return "comment";
    }

}
