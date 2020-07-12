package com.sdust.dao;

import com.sdust.pojo.Shopping;
import java.util.List;

public interface ShoppingMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Shopping record);

    Shopping selectByPrimaryKey(Integer sid);

    List<Shopping> selectAll();

    int updateByPrimaryKey(Shopping record);
}