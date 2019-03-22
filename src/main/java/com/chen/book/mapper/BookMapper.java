package com.chen.book.mapper;

import com.chen.book.entity.Book;

import java.util.List;

public interface BookMapper {
    int insertBook(Book book);

    int updateBook(Book book);

    List<Book> queryAllBook();
    Book queryBookById(int id);

    List<Book> queryBookByUserId(int userId);
    List<Book> queryBookUserResultMap();
    Book queryBookAreaResultMap(int bookId);
}
