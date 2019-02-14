package com.blog.dao.impl;

import com.blog.dao.IBlogTypeDao;
import com.blog.entity.BlogType;
import com.blog.util.DBUtil;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvconl
 * 类说明：博文类型相关操作实现类
 * */
public class BlogTypeDaoImpl implements IBlogTypeDao {
    private static Logger logger = Logger.getLogger(BlogTypeDaoImpl.class);
    /**
     * 根据参数判断博文类型是否存在
     * @param param (博文类型)
     * @return 存在返回true、否则返回false
     * */
    @Override
    public boolean isExist(String param) {
        return (queryBlogTypeByName(param)!= null) || (queryBlogTypeByName(param) != null);
    }
    /**
     * 新增博文类型
     *
     * @param blogType (博文类型实例)
     * @return 操作成功返回true，否则返回false
     */
    @Override
    public boolean addBlogType(BlogType blogType) {
        String sql = "INSERT INTO blog_type(id, type_name) VALUES(?, ?)";
        return DBUtil.executeUpdate(sql, blogType.getId(), blogType.getTypeName());
    }

    /**
     * 根据id删除博文类型
     *
     * @param id@return 操作成功返回true，否则返回false
     */
    @Override
    public boolean deleteBlogTypeById(String id) {
        String sql = "DELETE FROM blog_type WHERE id=?";
        return DBUtil.executeUpdate(sql, id);
    }

    /**
     * 更新博文类型
     *
     * @param id
     * @param blogType (修改后的博文类型实例)
     * @return 操作成功返回true，否则返回false
     */
    @Override
    public boolean updateBlogTypeById(String id, BlogType blogType) {
        String sql = "UPDATE blog_type SET type_name=? WHERE id=?";
        return DBUtil.executeUpdate(sql, blogType.getTypeName(), id);
    }

    /**
     * 查询所有博文类型
     *
     * @return 博文类型集合
     */
    @Override
    public List<BlogType> queryAllBlogType() {
        List<BlogType> blogTypes = new ArrayList<>();
        String sql = "SELECT * FROM blog_type";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            BlogType blogType = null;
            while (rs.next()) {
                blogType = new BlogType(rs.getString(1), rs.getString(2));
                blogTypes.add(blogType);
            }
        } catch (SQLException e) {
            logger.error("查询所有博文类型失败,SQL语句为<" + sql + ">...");
            e.printStackTrace();
        }
        return blogTypes;
    }

    /**
     * 根据博文类型名查询博文类型，防止重复添加
     *
     * @param typeName (博文类型名)
     * @return 存在返回相应的博文类型实例，否则返回null
     */
    @Override
    public BlogType queryBlogTypeByName(String typeName) {
        String sql = "SELECT * FROM blog_type WHERE type_name=?";
        return getBlogType(sql, typeName);
    }

    /**
     * 根据博文类型id查询博文类型
     *
     * @param id @return 存在返回相应的博文类型实例，否则返回null
     */
    @Override
    public BlogType queryBlogTypeById(String id) {
        String sql = "SELECT * FROM blog_type WHERE id=?";
        return getBlogType(sql, id);
    }
    /**
     * 通过SQL语句以及参数查询对应的博文类型
     * @param sql sql语句
     * @param param 参数
     * @return 通过参数查询到的博文类型
     * */
    private BlogType getBlogType (String sql, String param) {
        BlogType blogType = null;
        ResultSet rs = DBUtil.executeQuery(sql, param);
        try {
            if (rs.next()) {
                blogType = new BlogType(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            logger.error("通过类型名查询博文类型失败,SQL语句为<" + sql + ">,查询参数为<" + param + ">");
            e.printStackTrace();
        }
        return blogType;
    }
}
