package com.blog.service.impl;

import com.blog.dao.IArticleDao;
import com.blog.dao.impl.ArticleDaoImpl;
import com.blog.entity.Article;
import com.blog.service.IArticleService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author lvconl
 * 类说明：调用dao层相关方法、实现Article相关业务层方法
 * */
public class ArticleServiceImpl implements IArticleService {
    private IArticleDao articleDao = new ArticleDaoImpl();

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
     * 根据id查询博文、用于博文详情页以及博文编辑页
     *
     * @param id （博文id）
     * @return 所查询到的博文
     */
    @Override
    public Article queryArticleById(String id) {
        return articleDao.queryArticleById(id);
    }

    /**
     * 根据分页信息查询博文
     *
     * @param currentPage
     * @param pageSize
     * @return 所查询到的博文集合
     */
    @Override
    public List<Article> queryArticleByPage(int currentPage, int pageSize) {
        return articleDao.queryArticleByPage(currentPage, pageSize);
    }

    /**
     * 根据博文类型查询博文
     *
     * @param typeId (博文类型id)
     * @return 所查询到的博文集合
     */
    @Override
    public List<Article> queryArticleByType(String typeId) {
        return articleDao.queryArticleByType(typeId);
    }

    /**
     * 获取数据库内总文章数
     *
     * @return 返回数据库内总文章数
     */
    @Override
    public int getTotalCount() {
        return articleDao.getTotalCount();
    }

    /**
     * 新增博文
     *
     * @param content(博文内容)
     * @param typeId (博文类型id)
     * @return 操作状态，操作成功放回true，失败返回true
     */
    @Override
    public boolean addArticle(String title, String summary, String content, String typeId) {
        String id = getId();
        //生成唯一id值
        while (articleDao.isExist(id)) {
            id = getId();
        }
        Article article = new Article(id, title, summary, content, typeId);
        return articleDao.addArticle(article);
    }

    /**
     * 根据id删除博文
     *
     * @param id (所要删除的博文id)
     * @return 操作状态，操作成功放回true，失败返回true
     */
    @Override
    public boolean deleteArticleById(String id) {
        return articleDao.deleteArticleById(id);
    }

    /**
     * 根据id更新博文
     *
     * @param id      (博文id)
     * @param article (更改后的博文实例)
     * @return 操作状态，操作成功放回true，失败返回true
     */
    @Override
    public boolean updateArticle(String id, Article article) {
        return articleDao.updateArticle(id, article);
    }

    /**
     * 格式化文章时间
     *
     * @param articles (要格式化的文章集合)
     */
    @Override
    public void formatArticlesCreateDateToHour(List<Article> articles) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm aa", Locale.CHINESE);
        for (Article article : articles) {
            article.setTimeString(dateFormat.format(article.getCreateAt()));
        }
    }

    /**
     * 格式化单个文章的时间
     *
     * @param article
     */
    @Override
    public void formatArticleCreateDateToDay(Article article) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        article.setTimeString(dateFormat.format(article.getCreateAt()));
    }
}
