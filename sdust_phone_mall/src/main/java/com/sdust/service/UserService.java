package com.sdust.service;

import com.sdust.pojo.Users;
import com.sdust.util.ResultVo;

import javax.servlet.http.HttpSession;

public interface UserService {

    /**
     * 注册
     * @param users
     * @return
     */
    ResultVo regist(Users users);

    /**
     * 登录
     * @param users
     * @param session
     * @return
     */
    ResultVo login(Users users, HttpSession session);
}
