package com.chen.book.controller;

import com.chen.book.entity.Area;
import com.chen.book.entity.Book;
import com.chen.book.entity.Category;
import com.chen.book.entity.User;
import com.chen.book.service.AreaService;
import com.chen.book.service.BookCategoryService;

import com.chen.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private AreaService areaService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "uploadView")
    public String uploadBookView(Model model){
        List<Area> areaList=new ArrayList<>();
        List<Category> categoryList=new ArrayList<>();
        try {
            areaList=areaService.getAreaList();
            categoryList=bookCategoryService.getBookCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("areaList",areaList);
        model.addAttribute("categoryList",categoryList);
        return "upload";

    }

    @RequestMapping("book")
    public String upBook(Model model,String bookName, String bookDesc, int price, Integer userId, Integer categoryId,Integer areaId,HttpSession httpSession){
        Book book=new Book();
        User user=null;
        if(httpSession.getAttribute("loginUser")==null){
            model.addAttribute("msg","用户未登录");
            return "errorPage";
        }
        user=(User)httpSession.getAttribute("loginUser");
        Category category=new Category();
        Area area=new Area();
        area.setAreaId(areaId);
        category.setBookCategoryId(categoryId);
        user.getUserId();
        book.setUser(user);
        book.setBookDesc(bookDesc);
        book.setBookPrice(price);
        book.setBookName(bookName);
        book.setBookImg(null);

        book.setCategory(category);
        book.setArea(area);
        System.out.println(book.toString());

        bookService.insertBook(book);
        return "forward:/book/list";



    }


}
