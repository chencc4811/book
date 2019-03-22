package com.chen.book.service;

import com.chen.book.entity.Book;
import com.chen.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    public List<Book> bookList(){
        List<Book> books=new ArrayList<>();
        books=bookMapper.queryAllBook();
        return books;
    }


    public Book findBookById(int id){
        return bookMapper.queryBookById(id);

    }

    public List<Book> findBookByUserId(int userId){
        return bookMapper.queryBookByUserId(userId);

    }

    public Map<String,Object> insertBook(Book book){
        Map<String,Object> map=new HashMap<>();
        try {
            bookMapper.insertBook(book);
            map.put("msg","sucess");

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","error");
        }
        return map;
    }

    public List<Book> findBookUserResultMap(){
        return bookMapper.queryBookUserResultMap();

    }

    public Book findBookAreaResultMap(Integer bookId){
        return bookMapper.queryBookAreaResultMap(bookId);
    }
}
