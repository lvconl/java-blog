package com.blog.dao.impl;

import com.blog.dao.IArticleDao;
import com.blog.entity.Article;
import com.blog.util.DBUtil;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvconl
 * 类说明：博文相关操作实现类
 * */
public class ArticleDaoImpl implements IArticleDao {
    private Logger logger = Logger.getLogger(ArticleDaoImpl.class);
    /**
     * 根据id查询该文章是否存在
     *
     * @param id
     * @return 存在返回true，否则返回false
     */
    @Override
    public boolean isExist(String id) {
        return queryArticleById(id) != null;
    }

    /**
     * 根据id查询单个文章，用于单个博文展示页以及编辑页用
     *
     * @param id@return id对应的博文，没有则返回null
     */
    @Override
    public Article queryArticleById(String id) {
        String sql = "SELECT * FROM article WHERE id=?";
        ResultSet rs = DBUtil.executeQuery(sql, id);
        Article article = null;
        try {
            if (rs.next()) {
                article = new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException e) {
            logger.error("查询单个博文错误,SQL语句为<" + sql + ">,博文id为<" + id + ">...");
            e.printStackTrace();
        }
        return article;
    }

    /**
     * 根据当前页以及页面大小查询文章
     *
     * @param currentPage
     * @param pageSize
     * @return 所查询博文集合
     */
    @Override
    public List<Article> queryArticleByPage(int currentPage, int pageSize) {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM article LIMIT ?,?";
        ResultSet rs = DBUtil.executeQuery(sql, (currentPage - 1) * pageSize, pageSize);
        try {
            Article article = null;
            while (rs.next()) {
                article = new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                articles.add(article);
            }
        } catch (SQLException e) {
            logger.error("按页查询博文失败,SQL语句为<" + sql +">,页面为<" + currentPage +">...");
            e.printStackTrace();
        }
        return articles;
    }

    /**
     * 根据博文类型查询文章
     *
     * @param typeId 博文类型id
     * @return 所查询博文集合
     */
    @Override
    public List<Article> queryArticleByType(String typeId) {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM article WHERE type_id=?";
        ResultSet rs = DBUtil.executeQuery(sql, typeId);
        try {
            Article article = null;
            while (rs.next()) {
                article = new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                articles.add(article);
            }
        } catch (SQLException e) {
            logger.error("根据博文类型查询文章失败,SQL语句为<" + sql + ">,查询类型id为<" + typeId +">...");
            e.printStackTrace();
        }
        return articles;
    }

    /**
     * 获取数据库内总文章数
     *
     * @return 返回数据库内总文章数
     */
    @Override
    public int getTotalCount() {
        String sql = "SELECT count(1) FROM article";
        ResultSet rs = DBUtil.executeQuery(sql);
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("查询文章总数出错,SQL语句为<" + sql + ">...");
        }
        return count;
    }

    /**
     * 新增文章
     *
     * @param article@return 操作成功返回true，否则返回false
     */
    @Override
    public boolean addArticle(Article article) {
        if (isExist(article.getId())) {
            logger.info("该id已存在");
            return false;
        }
        String sql = "INSERT INTO article(id, title, summary, content, create_at, comment_count, like_count, type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return DBUtil.executeUpdate(sql, article.getId(), article.getTitle(), article.getSummary(), article.getContent(), article.getCreateAt(), 0, 0, article.getTypeId());
    }
    /**
     * 根据id删除文章
     *
     * @param id@return 操作成功返回true，否则返回false
     */
    @Override
    public boolean deleteArticleById(String id) {
        String sql = "DELETE FROM article WHERE id=?";
        return DBUtil.executeUpdate(sql, id);
    }
    /**
     * 更新文章内容
     *
     * @param id
     * @param article
     * @return 操作成功返回true，否则返回false
     */
    @Override
    public boolean updateArticle(String id, Article article) {
        String sql = "UPDATE article SET content=?,type_id=? WHERE id=?";
        return DBUtil.executeUpdate(sql, article.getContent(), article.getTypeId(), id);
    }

    public static void main(String[] args) {
        IArticleDao articleDao = new ArticleDaoImpl();
        List<Article> articles = articleDao.queryArticleByPage(1,3);
        System.out.println(articles.size());
    }
}
