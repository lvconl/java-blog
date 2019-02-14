package com.blog.util;

import org.apache.log4j.Logger;

import java.sql.*;
/**
 * @author lvconl
 * 数据库操作工具类
 * */
public class DBUtil {
    private static Logger logger = Logger.getLogger(DBUtil.class);
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/java-blog?useSSL=false&charset=utf8mb4";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123456";

    private static Connection connection = null;
    private static PreparedStatement pstmt = null;

    /**
     * 加载驱动文件以及获取数据库连接
     * */
    private static void getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            logger.info("获取数据库连接成功...");
        } catch (ClassNotFoundException e) {
            logger.error("加载数据库驱动错误...");
        } catch (SQLException e) {
            logger.error("获取数据库连接错误...");
        }
    }
    /**
     * 关闭数据连接等资源
     * */
    private static void closeSource() {
        try {
            if (pstmt != null){
                pstmt.close();
            }
            if (connection != null){
                connection.close();
            }
            logger.info("关闭数据库资源成功...");
        } catch (SQLException e) {
            logger.error("关闭数据库资源错误...");
        }
    }
    /**
     * 获取pstmt
     * @param sql，参数数组objects
     * @return pstmt
     * */
    private static void getPstmt(String sql, Object... params) {
        getConnection();
        try {
            pstmt = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0;i < params.length;i++){
                    pstmt.setObject(i + 1, params[i]);
                }
            }
        } catch (SQLException e) {
            logger.error("预编译SQL错误,SQL语句为<" + sql + ">...");
        }
    }
    /**
     * 通用查询方法
     * @param sql，参数数组
     * @return 查询结果集
     * */
    public static ResultSet executeQuery(String sql, Object... params) {
        getPstmt(sql, params);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            logger.error("执行QUERY错误,SQL语句为<" + sql +">...");
            e.printStackTrace();
        }
        return rs;
    }
    /**
     * 查询总数
     * */
    public static int getTotalCount(String sql) {
        getPstmt(sql);
        int count = -1;
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("查询总数失败,SQL语句为<" + sql + ">...");
        } finally {
            closeSource();
        }
        return count;
    }
    /**
     * 通用增加、删除、修改方法
     * @param sql
     * @param params
     * @return 执行状态，成功返回true、失败返回false
     * */
    public static boolean executeUpdate(String sql, Object... params) {
        getPstmt(sql, params);
        int count = 0;
        try {
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL执行UPDATE失败,SQL语句为<" + sql +">...");
            e.printStackTrace();
        } finally {
            closeSource();
        }
        return count > 0;
    }
}

