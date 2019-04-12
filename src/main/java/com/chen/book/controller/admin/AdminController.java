package com.chen.book.controller.admin;

import com.chen.book.bookUtils.BookUtil;
import com.chen.book.entity.Admin;
import com.chen.book.entity.Book;
import com.chen.book.entity.User;
import com.chen.book.service.BookService;
import com.chen.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin", produces = "text/html;charset=UTF-8")
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @RequestMapping("list")
    public String bookList(Model model) {
        List<Book> bookList = new ArrayList<>();
        bookList = bookService.findBookUserResultMap(0);
        model.addAttribute("bookList", bookList);
        return "admin/booklist";
    }


    @RequestMapping("delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId, HttpSession httpSession, Model model){
        if (httpSession.getAttribute("loginAdmin") == null) {
            model.addAttribute("msg", "用户未登录");
            return "errorPage";
        }

        bookService.deleteBook(bookId,1);
        return "forward:/admin/list";
    }

    @RequestMapping("userlist")
    public String userList(Model model){
        List<User> userList=new ArrayList<>();
        userList=userService.userList();
        model.addAttribute("userList",userList);

        return "admin/userlist";

    }
    @RequestMapping("adminlist")
    public String adminList(Model model){
        List<Admin> adminList=new ArrayList<>();
        adminList=userService.adminList();
        model.addAttribute("adminList",adminList);

        return "admin/adminlist";

    }

    @RequestMapping("deleteuser/{userId}")
    public String deleteUser(@PathVariable Integer userId, HttpSession httpSession, Model model){
        if (httpSession.getAttribute("loginAdmin") == null) {
            model.addAttribute("msg", "用户未登录");
            return "errorPage";
        }

        userService.deleteUser(userId);
        return "forward:/admin/userlist";
    }
    @RequestMapping("deleteadmin/{adminId}")
    public String deleteAdmin(@PathVariable Integer adminId, HttpSession httpSession, Model model){
        if (httpSession.getAttribute("loginAdmin") == null) {
            model.addAttribute("msg", "用户未登录");
            return "errorPage";
        }

        userService.deleteAdmin(adminId);
        return "forward:/admin/adminlist";
    }


    @RequestMapping("adminlogin")
    public String addAdmin(@RequestParam("username") String adminName,
                           @RequestParam("password") String password,
                           Model model, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            map=userService.loginAdmin(adminName,password);
            if(map.containsKey("admin")){
                Admin admin=(Admin) map.get("admin");
                HttpSession session = request.getSession();
                session.setAttribute("loginAdmin",admin);
                return "forward:/admin/list";
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


    @RequestMapping("addadmin")
    @ResponseBody
    public String addAdmin(@RequestParam("username") String adminName,
                           @RequestParam("password") String password,Model model){
        if(password.length()<6){
            model.addAttribute("msg","密码太短");
            return BookUtil.getJSONString(1, "密码太短");

        }
        Admin admin=new Admin();
        admin.setAdminName(adminName);
        admin.setPassword(password);
        Map<String, Object> map = null;

        try {

            map = userService.addAdmin(admin);
            if (map.containsKey("msgs")) {
                return BookUtil.getJSONString(0, "添加成功");
            } else {
                return BookUtil.getJSONString(1, map);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return BookUtil.getJSONString(1, "异常");
        }
    }

}
