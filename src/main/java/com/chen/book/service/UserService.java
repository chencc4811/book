package com.chen.book.service;

import com.chen.book.entity.LoginTicket;
import com.chen.book.entity.User;
import com.chen.book.mapper.LoginTicketMapper;
import com.chen.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;

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

}
