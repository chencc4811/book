package com.chen.book.mapper;

import com.chen.book.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookCategoryMapper {
    List<Category> queryBookCategory();
}
