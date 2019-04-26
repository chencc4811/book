package com.chen.book.controller;

import com.chen.book.entity.Book;
import com.chen.book.entity.Comment;
import com.chen.book.entity.User;
import com.chen.book.service.AreaService;
import com.chen.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("detail")
public class DetailController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AreaService areaService;

    @RequestMapping("toComm/{bookId}")
    public String toComm(@PathVariable Integer bookId ,Model model){
        System.out.println(bookId);
        model.addAttribute("bookId",bookId);
        return "comment";
    }


    @RequestMapping("book/{bookId}")
    public String bookDetail(@PathVariable Integer bookId, Model model){

//        Book book=bookService.findBookById(bookId);
//        Book book=bookService.findBookAreaResultMap(bookId);
        Book book=bookService.findBookUserAreaResultMap(bookId);
        List<Comment> comments=bookService.getComment(bookId);
        model.addAttribute("comments",comments);
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

    @RequestMapping("comment/{bookId}")
    public String addComment(@PathVariable int bookId, Model model, HttpSession httpSession,String comment){
        User user=new User();
        user=(User)httpSession.getAttribute("loginUser");
        if(httpSession.getAttribute("loginUser")==null){
            model.addAttribute("msg","用户未登录");
            return "errorPage";
        }
        Comment comment1=new Comment();
        comment1.setBookId(bookId);
        comment1.setUserId(user.getUserId());
        comment1.setComment(comment);
        bookService.addComment(comment1);
        return "forward:/book/list";




    }
}
