package com.sdust.service;

import com.qianfeng.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 根据tid查询商品
     * @param tid
     * @return
     */
    List<Book> getListByTypeId(Integer tid);

    /**
     * 根据图书id查询图书详情
     * @param bid
     * @return
     */
    Book getBookById(Integer bid);
}
