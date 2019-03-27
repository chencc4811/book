package com.chen.book.controller;

import com.chen.book.entity.Book;
import com.chen.book.entity.Deal;
import com.chen.book.service.BookDealService;
import com.chen.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDealService bookDealService;

    @RequestMapping("buy/{buyerId}/{sellerId}/{bookId}")
    public String buyBook(HttpSession httpSession, Model model,
                          @PathVariable Integer buyerId,@PathVariable Integer sellerId,@PathVariable Integer bookId){
        if(buyerId==sellerId){
            model.addAttribute("msg","不可以买自己发布的书籍");
            return "errorPage";
        }
        if(httpSession.getAttribute("loginUser")==null){
            model.addAttribute("msg","用户未登录");
            return "errorPage";
        }

        bookService.dealBook(sellerId,buyerId,bookId,1);
        return "forward:/book/list";

    }



    @RequestMapping("list")
    public String bookList(Model model){
        List<Book> bookList=new ArrayList<>();
       bookList=bookService.findBookUserResultMap(0);
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

        List<Deal> bookBuyList=null;
        bookBuyList=bookDealService.getBuyinfo(userId);
        model.addAttribute("bookBuyList",bookBuyList);

        return "userinfo";
    }


    @RequestMapping("edit1/{id}")
    public String bookEdit(@PathVariable Integer id, Model model){

        Book book=bookService.findBookById(id);
        model.addAttribute("book",book);


        return "editbook";
    }


    @RequestMapping("search")
    public String searchBook( Model model,@RequestParam String bookName){

        System.out.println(bookName);
        if(bookName==null){
            return "forward:/book/list";

        }
        List<Book> bookList=new ArrayList<>();

        bookList=bookService.searchBook(0,bookName);
        model.addAttribute("bookList",bookList);
        return "index";
    }

}
