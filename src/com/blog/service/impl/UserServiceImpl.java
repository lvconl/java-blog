package com.blog.service.impl;

import com.blog.dao.IUserDao;
import com.blog.dao.impl.UserDaoImpl;
import com.blog.entity.User;
import com.blog.service.IUserService;

/**
 * @author lvconl
 * 类说明：调用Userdao层相关方法，实现user业务层相关方法
 * */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    /**
     * 用户登录
     *
     * @param loginUser@return 查询到的用户
     */
    @Override
    public User login(User loginUser) {
        return userDao.login(loginUser);
    }
}
