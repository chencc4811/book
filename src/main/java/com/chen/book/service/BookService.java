package com.chen.book.service;

import com.chen.book.entity.Book;
import com.chen.book.entity.Deal;
import com.chen.book.mapper.BookDealMapper;
import com.chen.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookDealMapper bookDealMapper;
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

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","error");
        }
        return map;
    }

    public List<Book> findBookUserResultMap(Integer status){
        return bookMapper.queryBookUserResultMap(status);

    }

    public List<Book> searchBook(Integer status,String bookName){
        System.out.println(bookName);
        Book book=new Book();
        book.setStatus(status);
        book.setBookName(bookName);
        return bookMapper.searchBookUserResultMap(book);
    }
    public Book findBookUserAreaResultMap(Integer bookId){
        return bookMapper.queryBookUserAreaResultMap(bookId);

    }

    public Map<String,Object> dealBook(Integer sellerId, Integer buyerId, Integer bookId,Integer status){
        Map<String,Object> map=new HashMap<>();
        System.out.println(status);
        Book book=new Book();
        book.setBookId(bookId);
        book.setStatus(status);
        try {
            bookMapper.updateBookStatus(book);
            map.put("msg","update book succes");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","exception");

        }
        Deal deal=new Deal();
        deal.setBookId(bookId);
        deal.setBuyerId(buyerId);
        deal.setSellerId(sellerId);
        deal.setDealTime(new Date());
        try {
            bookDealMapper.insertBookDeal(deal);
            map.put("msg","insert error");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e);
        }
        map.put("msg","success");
        return map;


    }

    public Book findBookAreaResultMap(Integer bookId){
        return bookMapper.queryBookAreaResultMap(bookId);
    }

    public void updateBook(Book book){
        bookMapper.updateBook(book);
    }
}
