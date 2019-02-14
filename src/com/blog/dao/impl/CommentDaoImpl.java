package com.blog.dao.impl;

import com.blog.dao.ICommentDao;
import com.blog.entity.Comment;
import com.blog.util.DBUtil;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvconl
 * 类说明：实现评论相关dao层方法
 * */
public class CommentDaoImpl implements ICommentDao {
    private static Logger logger = Logger.getLogger(CommentDaoImpl.class);
    /**
     * 新增评论
     *
     * @param comment@return 操作状态,成功返回true，失败返回false
     */
    @Override
    public boolean addComment(Comment comment) {
        String sql = "INSERT INTO comment(id, content, article_id, create_at) VALUES(?, ?, ?, ?)";
        return DBUtil.executeUpdate(sql, comment.getId(), comment.getContent(), comment.getArticleId(), comment.getCreateAt());
    }

    /**
     * 根据编号删除评论
     *
     * @param id@return 操作状态,成功返回true，失败返回false
     */
    @Override
    public boolean deleteCommentById(String id) {
        String sql = "DELETE FROM comment WHERE id=?";
        return DBUtil.executeUpdate(sql, id);
    }

    /**
     * 通过文章id查询评论
     *
     * @param articleId@return 查询到的文章集合
     */
    @Override
    public List<Comment> queryCommentByArticleId(String articleId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE article_id=?";
        ResultSet rs = DBUtil.executeQuery(sql, articleId);
        try {
            Comment comment = null;
            while (rs.next()) {
                comment = new Comment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                comments.add(comment);
            }
        } catch (SQLException e) {
            logger.error("按文章id查询评论失败,SQL语句为<" + sql +">,文章id为<" + articleId + ">...");
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * 根据分页信息查询评论
     *
     * @param currentPage
     * @param pageSize
     * @return 查询到的文章集合
     */
    @Override
    public List<Comment> queryCommentByPageAndArticleId(String articleId,int currentPage, int pageSize) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE article_id=? LIMIT ?,?";
        ResultSet rs = DBUtil.executeQuery(sql, articleId, (currentPage - 1) * pageSize, pageSize);
        try {
            Comment comment = null;
            while (rs.next()) {
                comment = new Comment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                comments.add(comment);
            }
        } catch (SQLException e) {
            logger.error("按分页信息查询评论失败,SQL语句为<" + sql +">,分页信息为<" + currentPage + "," + pageSize + ">...");
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * 获得总评论数
     *
     * @param articleId (文章id)
     * @return 总评论数
     */
    @Override
    public int getTotalCount(String articleId) {
        String sql = "SELECT COUNT(1) FROM comment WHERE article_id=?";
        int count = 0;
        ResultSet rs = DBUtil.executeQuery(sql, articleId);
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("获得评论总数失败,SQL语句为<" + sql + ">,文章id为<" + articleId + ">...");
        }
        return count;
    }
}
