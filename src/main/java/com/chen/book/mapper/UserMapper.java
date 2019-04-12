package com.chen.book.mapper;

import com.chen.book.entity.User;

import java.util.List;

public interface UserMapper {
    int insertUser(User user);

    User selectById(int id);
    User selectByUserName(String name);

    List<User> queryAllUser();

    void deleteUser(int id);


}
