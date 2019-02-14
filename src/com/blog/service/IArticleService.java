package com.blog.service;


import com.blog.entity.Article;

import java.util.List;

/**
 * @author lvconl
 * 类说明:抽象定义Article相关业务层方法
 * */
public interface IArticleService {
    /**
     * 根据id查询博文、用于博文详情页以及博文编辑页
     * @param id（博文id）
     * @return 所查询到的博文
     * */
    Article queryArticleById(String id);
    /**
     * 根据分页信息查询博文
     * @param currentPage(当前页)
     * @param pageSize(页面大小)
     * @return 所查询到的博文集合
     * */
    List<Article> queryArticleByPage(int currentPage, int pageSize);
    /**
     * 根据博文类型查询博文
     * @param typeId (博文类型id)
     * @return 所查询到的博文集合
     * */
    List<Article> queryArticleByType(String typeId);
    /**
     * 获取数据库内总文章数
     * @return 返回数据库内总文章数
     * */
    int getTotalCount();
    /**
     * 新增博文
     * @param content(博文内容)
     * @param typeId (博文类型id)
     * @return 操作状态，操作成功放回true，失败返回true
     * */
    boolean addArticle(String title, String summary, String content, String typeId);
    /**
     * 根据id删除博文
     * @param id (所要删除的博文id)
     * @return 操作状态，操作成功放回true，失败返回true
     * */
    boolean deleteArticleById(String id);
    /**
     * 根据id更新博文
     * @param id (博文id)
     * @param article (更改后的博文实例)
     * @return 操作状态，操作成功放回true，失败返回true
     * */
    boolean updateArticle(String id, Article article);
    /**
     * 格式化文章集合文章时间
     * @param articles (要格式化的文章集合)
     * */
    void formatArticlesCreateDateToHour(List<Article> articles);
    /**
     * 格式化单个文章的时间
     * @param article(要格式化的文章)
     * */
    void formatArticleCreateDateToDay(Article article);
}