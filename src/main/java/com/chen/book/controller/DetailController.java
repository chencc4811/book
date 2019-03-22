package com.chen.book.controller;

import com.chen.book.entity.Area;
import com.chen.book.entity.Book;
import com.chen.book.service.AreaService;
import com.chen.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        Book book=bookService.findBookAreaResultMap(bookId);

        model.addAttribute("bookDetail",book);
        return "detail";



    }
}
