package com.chen.book.controller;

import com.chen.book.entity.Book;
import com.chen.book.entity.User;
import com.chen.book.entity.ViewObj;
import com.chen.book.service.BookService;
import com.chen.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;



    @RequestMapping("list")
    public String bookList(Model model){
        List<Book> bookList=new ArrayList<>();
//        bookList=bookService.bookList();
        for(Book book:bookList){
            System.out.println(book);
        }

       bookList=bookService.findBookUserResultMap();
//        List<ViewObj> vos=new ArrayList<>();
//        for(Book book:bookList){
//            ViewObj vo=new ViewObj();
//            vo.set("book",book);
//            vo.set("user",userService.findUserById(book.getUserId()));
//            vos.add(vo);
//        }
//
//        model.addAttribute("vos",vos);


        model.addAttribute("bookList",bookList);
        return "index";
    }

    @RequestMapping("listById")
    public String bookListById(Model model,@RequestParam(value = "userId",defaultValue ="-1") Integer userId){
        List<Book> bookList=null;

        if(userId==-1){
            model.addAttribute("msg","用户未登录");
            return "errorPage";
        }
        bookList=bookService.findBookByUserId(userId);

        model.addAttribute("bookList",bookList);
        return "userinfo";
    }


    @RequestMapping("edit1/{id}")
    public String bookEdit(@PathVariable Integer id, Model model){

        Book book=bookService.findBookById(id);
        model.addAttribute("book",book);


        return "editbook";
    }

}
