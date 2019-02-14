package com.blog.dao;

import com.blog.entity.Comment;

import java.util.List;

/**
 * @author lvconl
 * 类说明：抽象定义comment相关dao层方法
 * */
public interface ICommentDao {
    /**
     * 新增评论
     * @param comment(新增评论实例)
     * @return 操作状态,成功返回true，失败返回false
     * */
    boolean addComment(Comment comment);
    /**
     * 根据编号删除评论
     * @param id(要删除的评论id)
     * @return 操作状态,成功返回true，失败返回false
     * */
    boolean deleteCommentById(String id);
    /**
     * 通过文章id查询评论
     * @param articleId(文章id)
     * @return 查询到的文章集合
     * */
    List<Comment> queryCommentByArticleId(String articleId);
    /**
     * 根据分页信息查询评论
     * @param currentPage(当前页)
     * @param pageSize(页面大小)
     * @return 查询到的文章集合
     * */
    List<Comment> queryCommentByPageAndArticleId(String articleId, int currentPage, int pageSize);
    /**
     * 获得总评论数
     * @param articleId (文章id)
     * @return 总评论数
     * */
    int getTotalCount(String articleId);
}
