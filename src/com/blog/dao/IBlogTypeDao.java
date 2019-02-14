package com.blog.dao;

import com.blog.entity.BlogType;

import java.util.List;

/**
 * @author lvconl
 * 类说明：博文类型相关操作
 * */
@SuppressWarnings("ALL")
public interface IBlogTypeDao {
    /**
     * 根据id查询该博文类型是否存在
     * @param id (博文id)
     * @return 存在返回true、否则返回false
     * */
    boolean isExist(String id);
    /**
     * 新增博文类型
     * @param blogType (博文类型实例)
     * @return 操作成功返回true，否则返回false
     * */
    boolean addBlogType (BlogType blogType);
    /**
     * 根据id删除博文类型
     * @param id(博文类型id)
     * @return 操作成功返回true，否则返回false
     * */
    boolean deleteBlogTypeById(String id);
    /**
     * 更新博文类型
     * @param id(博文类型id)
     * @param blogType (修改后的博文类型实例)
     * @return 操作成功返回true，否则返回false
     * */
    boolean updateBlogTypeById(String id, BlogType blogType);
    /**
     * 查询所有博文类型
     * @return 博文类型集合
     * */
    List<BlogType> queryAllBlogType();
    /**
     * 根据博文类型名查询博文类型，防止重复添加
     * @param typeName (博文类型名)
     * @return 存在返回相应的博文类型实例，否则返回null
     * */
    BlogType queryBlogTypeByName(String typeName);
    /**
     * 根据博文类型id查询博文类型
     * @param id(博文类型id)
     * @return 存在返回相应的博文类型实例，否则返回null
     * */
    BlogType queryBlogTypeById(String id);
}
