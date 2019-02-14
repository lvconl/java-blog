package com.blog.service;

import com.blog.entity.BlogType;

import java.util.List;

/**
 * @author lvconl
 * 类说明：定义博文类型相关操作方法
 * */
public interface IBlogTypeService {
    /**
     * 查询所有博文类型
     * @return 所查询到的博文集合
     * */
    List<BlogType> queryAllBlogType();
    /**
     * 根据id查询博文类型
     * @param id (博文类型id)
     * @return 所查询到的博文
     * */
    BlogType queryBlogTypeById(String id);
    /**
     * 根据博文名查询博文
     * @param typeName(博文名)
     * @return 所查询到的博文
     * */
    BlogType queryBlogTypeByName(String typeName);
    /**
     * 新增博文类型
     * @param typeName(博文类型名)
     * @return 操作状态，成功返回true、失败返回false
     * */
    boolean addBlogType(String typeName);
    /**
     * 根据id删除博文类型
     * @param id (博文类型id)
     * @return 操作状态，成功返回true、失败返回false
     * */
    boolean deleteBlogTypeById(String id);
    /**
     * 更新博文类型
     * @param id (博文类型id)
     * @param blogType (博文类型实例)
     * @return 操作状态，成功返回true、失败返回false
     * */
    boolean updateBlogType(String id, BlogType blogType);
}
