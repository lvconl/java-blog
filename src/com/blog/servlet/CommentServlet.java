package com.blog.servlet;

import com.blog.service.ICommentService;
import com.blog.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lvconl
 * 类说明：处理评论相关请求
 * */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ICommentService commentService = new CommentServiceImpl();
        String param = request.getParameter("param");
        String addComment = "add";
        if (addComment.equals(param)) {
            String content = request.getParameter("content");
            String articleId = request.getParameter("articleId");
            if (commentService.addComment(content, articleId)) {
                response.sendRedirect("ArticleServlet?param=detail&articleId=" + articleId);
            } else {
                response.sendRedirect("404.jsp");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
