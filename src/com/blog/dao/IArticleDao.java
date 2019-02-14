package com.blog.dao;

import com.blog.entity.Article;

import java.util.List;
/**
 * @author lvconl
 * 接口说明：文章相关操作方法
 * */
@SuppressWarnings("ALL")
public interface IArticleDao {
    /**
     * 根据id查询该文章是否存在
     * @param id(博文id)
     * @return 存在返回true，否则返回false
     * */
    boolean isExist(String id);
    /**
     * 根据id查询单个文章，用于单个博文展示页以及编辑页用
     * @param id(博文id)
     * @return id对应的博文，没有则返回null
     * */
    Article queryArticleById(String id);
    /**
     * 根据当前页以及页面大小查询文章
     * @param currentPage(当前页面)
     * @param pageSize(页面大小)
     * @return 所查询博文集合
     * */
    List<Article> queryArticleByPage(int currentPage, int pageSize);
    /**
     * 根据博文类型查询文章
     * @param typeId 博文类型id
     * @return 所查询博文集合
     * */
    List<Article> queryArticleByType(String typeId);
    /**
     * 获取数据库内总文章数
     * @return 返回数据库内总文章数
     * */
    int getTotalCount();
    /**
     * 新增文章
     * @param article(博文实例)
     * @return 操作成功返回true，否则返回false
     * */
    boolean addArticle(Article article);
    /**
     * 根据id删除文章
     * @param id(文章id)
     * @return 操作成功返回true，否则返回false
     * */
    boolean deleteArticleById(String id);
    /**
     * 更新文章内容
     * @param id(博文id)
     * @param article(修改后的博文实例)
     * @return 操作成功返回true，否则返回false
     * */
    boolean updateArticle(String id, Article article);
}