package com.sdust.controller;

import com.qianfeng.pojo.Book;
import com.qianfeng.pojo.Shopping;
import com.qianfeng.service.BookService;
import com.qianfeng.service.ShoppingService;
import com.qianfeng.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController//即是controller,又能返回json对象
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ShoppingService shoppingService;

    /**
     * 根据类型查询所有图书
     */
    @RequestMapping("/getListById")
    public ResultVo getListByTypeId(Integer tid){
        System.out.println(tid);
        List<Book> bookList = bookService.getListByTypeId(tid);
        return ResultVo.success("success",bookList);
    }
    /**
     * 根据图书id查询图书详情
     */
    @RequestMapping("/getBookById")
    public ResultVo getBookById(Integer bid){
        Book book = bookService.getBookById(bid);
        return ResultVo.success("success",book);
    }

    /**
     * 添加到购物车
     */
    @RequestMapping("/addShopping")
    public ResultVo addShopping(@RequestBody Shopping shopping, HttpSession session){
        ResultVo resultVo = shoppingService.addShopping(shopping,session);
        return resultVo;
    }
    /**
     * 根据用户id查询购物车列表
     */
    @RequestMapping("/getShoppingList")
    public ResultVo getShoppingList(HttpSession session){
        ResultVo resultVo = shoppingService.getShoppingList(session);
        return resultVo;
    }
}
