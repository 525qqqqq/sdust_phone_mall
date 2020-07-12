package com.sdust.service;

import com.qianfeng.dao.BookMapper;
import com.qianfeng.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getListByTypeId(Integer tid) {
        List<Book> bookList = bookMapper.getListByTypeId(tid);
        return bookList;
    }

    @Override
    public Book getBookById(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }
}
