package com.blog.service;

import com.blog.entity.Comment;

import java.util.List;

/**
 * @author lvconl
 * 抽象定义评论service层方法
 * */
public interface ICommentService {
    /**
     * 新增评论
     * @param content(新增评论实例)
     * @param articleId (文章id)
     * @return 操作状态，成功返回true、失败返回false
     * */
    boolean addComment(String content, String articleId);
    /**
     * 根据id删除评论
     * @param id
     * */
    boolean deleteCommentById(String id);
    /**
     * 根据文章id查询评论
     * @param articleId (文章id)
     * @return 根据id查询到的评论集合
     * */
    List<Comment> queryCommentByArticleId(String articleId);
    /**
     * 根据分页信息查询评论
     * @param articleId (文章id)
     * @param currentPage (当前页)
     * @param pageSize (页面大小)
     * */
    List<Comment> queryCommentByPageAndArticleId(String articleId, int currentPage, int pageSize);
    /**
     * 获得总评论数
     * @param articleId (文章id)
     * @return 总评论数
     * */
    int getTotalCount(String articleId);
}
