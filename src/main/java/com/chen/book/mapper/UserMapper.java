package com.chen.book.mapper;

import com.chen.book.entity.User;

public interface UserMapper {
    int insertUser(User user);

    User selectById(int id);
    User selectByUserName(String name);


}
