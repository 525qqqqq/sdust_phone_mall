package com.sdust.dao;

import com.sdust.pojo.Users;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    Users selectByPrimaryKey(Integer uid);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
}