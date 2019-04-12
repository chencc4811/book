package com.chen.book.mapper;

import com.chen.book.entity.Admin;
import com.chen.book.entity.User;

import java.util.List;

public interface AdminMapper {
    int insertAdmin(Admin admin);

//    User selectById(int id);
    Admin selectByAdminName(String name);

    List<Admin> queryAllAdmin();

    void deleteAdmin(int id);
}
