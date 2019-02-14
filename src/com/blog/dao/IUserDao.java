package com.blog.dao;

import com.blog.entity.User;

/**
 * @author lvconl
 * 类说明：网站用户相关操作Dao层方法定义
 * */
public interface IUserDao {
    /**
     * 用户登录
     * @param loginUser (登录的用户实例)
     * @return 数据库查询到用户
     * */
    User login(User loginUser);
}
