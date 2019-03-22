package com.chen.book.service;

import com.chen.book.entity.Category;
import com.chen.book.mapper.BookCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {
    @Autowired
    private BookCategoryMapper bookCategoryMapper;
    public List<Category> getBookCategory(){
        return bookCategoryMapper.queryBookCategory();
    }

}
