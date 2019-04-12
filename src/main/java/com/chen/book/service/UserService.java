package com.chen.book.service;

import com.chen.book.entity.Admin;
import com.chen.book.entity.LoginTicket;
import com.chen.book.entity.User;
import com.chen.book.mapper.AdminMapper;
import com.chen.book.mapper.LoginTicketMapper;
import com.chen.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;
    @Autowired
    private AdminMapper adminMapper;

    public Map<String, Object> addUser(User user) {
        Map<String, Object> map = new HashMap<>();
        if (user.getUserName().equals(null)) {
            map.put("msg", "用户名不能为空");
        }
        if (user.getPassword().equals(null)) {
            map.put("msg", "密码不能为空");
        }
        User user1 = userMapper.selectByUserName(user.getUserName());
        if (user1 != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }
        userMapper.insertUser(user);
        map.put("msgs","success");

        return map;


    }

    public Map<String, Object> login(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = userMapper.selectByUserName(name);
        if (user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }
        if (user != null && !(user.getPassword().equals(password))) {
            map.put("msg", "密码错误");
            return map;
        }
        map.put("user",user);
        System.out.println(user.toString());
//        String ticket = addLoginTicket(user.getUserId());
//        map.put("ticket", ticket);
        return map;
    }
    public Map<String, Object> loginAdmin(String name, String password) {
        Map<String, Object> map = new HashMap<>();


        Admin admin=adminMapper.selectByAdminName(name);
        if (admin == null) {
            map.put("msg", "用户名不存在");
            return map;
        }
        if (admin != null && !(admin.getPassword().equals(password))) {
            map.put("msg", "密码错误");
            return map;
        }
        map.put("admin",admin);
        System.out.println(admin.toString());

        return map;
    }



    private String addLoginTicket(int userId) {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketMapper.addTicket(loginTicket);
        return loginTicket.getTicket();

    }

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

    public List<User> userList(){
        List<User> userList=new ArrayList<>();

        userList=userMapper.queryAllUser();
        return userList;

    }
    public List<Admin> adminList(){
        List<Admin> adminList=new ArrayList<>();

        adminList=adminMapper.queryAllAdmin();
        return adminList;

    }


    public Map<String,Object> deleteUser(Integer userId){
        Map<String, Object> map = new HashMap<>();
        try {
            userMapper.deleteUser(userId);
            map.put("success","ok");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","no");
        }
        return map;


    }
    public Map<String,Object> deleteAdmin(Integer adminId){
        Map<String, Object> map = new HashMap<>();
        try {
            adminMapper.deleteAdmin(adminId);
            map.put("success","ok");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","no");
        }
        return map;


    }


    public Map<String,Object> addAdmin(Admin admin){
        Map<String, Object> map = new HashMap<>();
        if (admin.getAdminName().equals(null)) {
            map.put("msg", "用户名不能为空");
        }
        if (admin.getPassword().equals(null)) {
            map.put("msg", "密码不能为空");
        }
        Admin  admin1 = adminMapper.selectByAdminName(admin.getAdminName());
        if (admin1 != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }
        adminMapper.insertAdmin(admin);
        map.put("msgs","success");

        return map;
    }

}
