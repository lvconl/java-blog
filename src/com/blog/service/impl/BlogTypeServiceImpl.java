package com.blog.service.impl;

import com.blog.dao.IBlogTypeDao;
import com.blog.dao.impl.BlogTypeDaoImpl;
import com.blog.entity.BlogType;
import com.blog.service.IBlogTypeService;

import java.util.List;
import java.util.Random;

/**
 * @author lvconl
 * 类说明:调用dao层方法，实现BlogType相关业务层方法
 * */
public class BlogTypeServiceImpl implements IBlogTypeService {
    private IBlogTypeDao blogTypeDao = new BlogTypeDaoImpl();
    /**
     * 随机生成id
     *
     * @return 随机产生的id
     */
    private String getId() {
        long simple = System.currentTimeMillis();
        int random = new Random().nextInt(999) + 100;
        return Long.toString(simple) + random;
    }
    /**
     * 查询所有博文类型
     *
     * @return 所查询到的博文集合
     */
    @Override
    public List<BlogType> queryAllBlogType() {
        return blogTypeDao.queryAllBlogType();
    }

    /**
     * 根据id查询博文类型
     *
     * @param id (博文类型id)
     * @return 所查询到的博文
     */
    @Override
    public BlogType queryBlogTypeById(String id) {
        return blogTypeDao.queryBlogTypeById(id);
    }

    /**
     * 根据博文名查询博文
     *
     * @param typeName@return 所查询到的博文
     */
    @Override
    public BlogType queryBlogTypeByName(String typeName) {
        return blogTypeDao.queryBlogTypeByName(typeName);
    }

    /**
     * 新增博文类型
     *
     * @param typeName@return 操作状态，成功返回true、失败返回false
     */
    @Override
    public boolean addBlogType(String typeName) {
        String id = getId();
        //生成唯一id
        while (blogTypeDao.isExist(id)) {
            id = getId();
        }
        BlogType blogType= new BlogType(id, typeName);
        return blogTypeDao.addBlogType(blogType);
    }

    /**
     * 根据id删除博文类型
     *
     * @param id (博文类型id)
     * @return 操作状态，成功返回true、失败返回false
     */
    @Override
    public boolean deleteBlogTypeById(String id) {
        return blogTypeDao.deleteBlogTypeById(id);
    }

    /**
     * 更新博文类型
     *
     * @param id       (博文类型id)
     * @param blogType (博文类型实例)
     * @return 操作状态，成功返回true、失败返回false
     */
    @Override
    public boolean updateBlogType(String id, BlogType blogType) {
        return blogTypeDao.updateBlogTypeById(id, blogType);
    }
}
