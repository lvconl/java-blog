package com.blog.service;

import com.blog.entity.User;

/**
 * @author lvconl
 * 类说明：抽象定义user业务层方法
 * */
public interface IUserService {
    /**
     * 用户登录
     * @param loginUser(登录用户实例)
     * @return 查询到的用户
     * */
    User login(User loginUser);
}
