package com.chen.book.mapper;

import com.chen.book.entity.Book;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {
    int insertBook(Book book);

    int updateBook(Book book);

    List<Book> queryAllBook();

    Book queryBookById(int id);

    List<Book> queryBookByUserId(int userId);
    List<Book> queryBookUserResultMap(Integer status);
    Book queryBookAreaResultMap(int bookId);
    Book queryBookUserAreaResultMap(int bookId);
    int updateBookStatus(Book book);
    List<Book> searchBookUserResultMap(Book book);


}
