package com.sdust.service;

import com.sdust.dao.UsersMapper;
import com.sdust.pojo.Users;
import com.sdust.util.Md5Util;
import com.sdust.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ResultVo regist(Users users) {
        System.out.println("111111");
        //先根据username查询是否对象是否为空
        Users selectUser = usersMapper.getUserByUsername(users);
        if(selectUser!=null){
            //手机号已被使用，请重新注册
            return ResultVo.error("手机号已存在,注册失败");
        }else{
            //直接注册就行了
            //将密码更换为加盐加密之后的结果
            users.setPassword(Md5Util.secret(users.getUsername(),users.getPassword()));
            usersMapper.regist(users);
            return ResultVo.success("注册成功");
        }
    }

    @Override
    public ResultVo login(Users users, HttpSession session) {
        //登录成功的条件:先根据用户名查询对象是否存在.
        // 如果存在比较密码,如果不存在,直接返回登录失败
        Users loginUser = usersMapper.getUserByUsername(users);
        if(loginUser==null || !loginUser.getPassword().equals(Md5Util.secret(users.getUsername(),users.getPassword()))){
            return ResultVo.error("用户名或者密码错误,登录失败");
        }else{
            //登录成功
            session.setAttribute("loginUser",loginUser);
            //前端页面中不能使用后端session中的数据,所以我们登录成功之后需要将数据返回给前端使用
            return ResultVo.success("登录成功",loginUser);
        }
    }
}
