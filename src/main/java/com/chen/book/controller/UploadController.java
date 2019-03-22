package com.chen.book.controller;

import com.chen.book.bookUtils.FileUtil;
import com.chen.book.bookUtils.ImageUtil;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String upBook(Model model,String bookName,
                         String bookDesc, int price,
                         Integer userId, Integer categoryId,
                         Integer areaId,HttpSession httpSession,
                         @RequestParam("bookPic") MultipartFile bookPic){
        Book book=new Book();
        User user=null;
        Map<String,Object> map=new HashMap<>();
        if(httpSession.getAttribute("loginUser")==null){
            model.addAttribute("msg","用户未登录");
            return "errorPage";
        }
        String basePath= FileUtil.getImgBasePath();
        String orginalPicName=bookPic.getOriginalFilename();
        String fileExetension= orginalPicName.substring(orginalPicName.lastIndexOf("."));
        String newName=FileUtil.getRandomFileName()+fileExetension;
        String sqlUrl=newName;
        File file=new File(basePath+newName);
        try {
            bookPic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("msg",e);
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
        book.setBookImg(sqlUrl);

        book.setCategory(category);
        book.setArea(area);
        System.out.println(book.toString());

        try {
            map=bookService.insertBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "forward:/book/list";



    }


}
