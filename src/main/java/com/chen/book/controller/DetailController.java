package com.chen.book.controller;

import com.chen.book.entity.Book;
import com.chen.book.service.AreaService;
import com.chen.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("detail")
public class DetailController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AreaService areaService;

    @RequestMapping("toComm")
    public String toComm(Model model){



        return "comment";
    }


    @RequestMapping("book/{bookId}")
    public String bookDetail(@PathVariable Integer bookId, Model model){

//        Book book=bookService.findBookById(bookId);
//        Book book=bookService.findBookAreaResultMap(bookId);
        Book book=bookService.findBookUserAreaResultMap(bookId);
        System.out.println(book);


        model.addAttribute("bookDetail",book);
        return "detail";

    }

    @RequestMapping("buy")
    public String buyBook(@RequestParam(value = "bookId",defaultValue = "-1") Integer bookId, Model model){
        if(bookId==-1){
            model.addAttribute("msg","请登录");
            return "errorPage";
        }
        return null;
    }
}
