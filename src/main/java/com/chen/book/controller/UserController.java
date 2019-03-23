package com.chen.book.controller;

import com.chen.book.bookUtils.BookUtil;
import com.chen.book.entity.User;
import com.chen.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "user", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    @ResponseBody
    public String reg(@RequestParam("username") String userName,
                      @RequestParam("password") String password,
                      @RequestParam("phone") String phone,Model model) {
        if(password.length()<6){
            model.addAttribute("msg","密码太短");
            return BookUtil.getJSONString(1, "密码太短");

        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setHeadPic(null);
        Map<String, Object> map = null;
        try {

            map = userService.addUser(user);
            if (map.containsKey("msgs")) {
                return BookUtil.getJSONString(0, "注册成功");
            } else {
                return BookUtil.getJSONString(1, map);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return BookUtil.getJSONString(1, "异常");
        }



    }
    @RequestMapping(value = "login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        @RequestParam(value = "switch",defaultValue = "0")int swith,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        Model model) {
        Map<String, Object> map = new HashMap<>();
        try {
            map=userService.login(userName,password);
            if(map.containsKey("user")){
                User user=(User) map.get("user");
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",user);
                return "forward:/book/list";
            }else {
                model.addAttribute("msg", map.get("msg"));
                return "errorPage";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", map.get("msg"));
            return "errorPage";

        }


    }

    @RequestMapping("loginOut")
    @ResponseBody
    public String loginOut(HttpServletRequest request,Model model){
        HttpSession session=request.getSession(false);
        if (session==null){
            model.addAttribute("msg","您未登录，无需退出");
            return "error";
        }
        session.removeAttribute("loginUser");
        model.addAttribute("msg","您已成功退出");
        return "success";


    }


    @RequestMapping(value = "login2")
    public String login2(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                     @RequestParam(value = "switch",defaultValue = "0")int swith,
                        HttpServletResponse response,
                        Model model) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = userService.login(userName, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                response.addCookie(cookie);
                cookie.setPath("/");
                return "forward:/book/list";
            } else {
//                return BookUtil.getJSONString(1,map);
                model.addAttribute("msg", map.get("msg"));
                return "errorPage";
            }
        } catch (Exception e) {
            e.printStackTrace();
//            return BookUtil.getJSONString(1,"异常");
            model.addAttribute("msg", map.get("msg"));
            return "errorPage";


        }


    }



}
