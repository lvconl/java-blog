package com.blog.dao.impl;

import com.blog.dao.IUserDao;
import com.blog.entity.User;
import com.blog.util.DBUtil;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lvconl
 * 类说明：用户相关dao层方法实现
 * */
public class UserDaoImpl implements IUserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);
    /**
     * 用户登录
     *
     * @param user@return 数据库查询到用户
     */
    @Override
    public User login(User loginUser) {
        User user = null;
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        ResultSet rs = DBUtil.executeQuery(sql, loginUser.getUsername(), loginUser.getPassword());
        try {
            if (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            logger.error("用户登录失败,SQL语句为<" + sql +">,用户名为<" + loginUser.getUsername() + ">...");
        }
        return user;
    }
}
