package com.chen.book;

import com.chen.book.entity.User;
import com.chen.book.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void insertTest(){
        User user=new User();
        user.setUserName("test");

        user.setPhone("173");
        user.setHeadPic("/d/f.jpg");
        int num=userMapper.insertUser(user);
        System.out.println(num);
    }




}
