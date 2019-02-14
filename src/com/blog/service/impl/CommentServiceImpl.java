package com.blog.service.impl;

import com.blog.dao.ICommentDao;
import com.blog.dao.impl.CommentDaoImpl;
import com.blog.entity.Comment;
import com.blog.service.ICommentService;

import java.util.List;
import java.util.Random;

/**
 * @author lvconl
 * 类说明：实现评论业务层方法
 * */
public class CommentServiceImpl implements ICommentService {
    private ICommentDao commentDao = new CommentDaoImpl();
    /**
     * 当前时间戳+三位随机数生成id
     *
     * @return 随机产生的id
     */
    private String getId() {
        long simple = System.currentTimeMillis();
        int random = new Random().nextInt(999) + 100;
        return Long.toString(simple) + random;
    }
    /**
     * 新增评论
     *
     * @param content
     * @param articleId
     * @return 操作状态，成功返回true、失败返回false
     */
    @Override
    public boolean addComment(String content, String articleId) {
        String id = getId();
        Comment comment = new Comment(id, content, articleId);
        return commentDao.addComment(comment);
    }

    /**
     * 根据id删除评论
     *
     * @param id
     */
    @Override
    public boolean deleteCommentById(String id) {
        return commentDao.deleteCommentById(id);
    }

    /**
     * 根据文章id查询评论
     *
     * @param articleId (文章id)
     * @return 根据id查询到的评论集合
     */
    @Override
    public List<Comment> queryCommentByArticleId(String articleId) {
        return commentDao.queryCommentByArticleId(articleId);
    }

    /**
     * 根据分页信息查询评论
     * @param articleId (文章id)
     * @param currentPage (当前页)
     * @param pageSize    (页面大小)
     */
    @Override
    public List<Comment> queryCommentByPageAndArticleId(String articleId, int currentPage, int pageSize) {
        return commentDao.queryCommentByPageAndArticleId(articleId, currentPage, pageSize);
    }

    /**
     * 获得总评论数
     *
     * @param articleId
     * @return 总评论数
     */
    @Override
    public int getTotalCount(String articleId) {
        return commentDao.getTotalCount(articleId);
    }
}
