package com.sdust.dao;

import com.sdust.pojo.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Order record);

    Order selectByPrimaryKey(Integer oid);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}