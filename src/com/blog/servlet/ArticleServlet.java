package com.blog.servlet;

import com.blog.entity.Article;
import com.blog.entity.BlogType;
import com.blog.entity.Comment;
import com.blog.entity.CommentPage;
import com.blog.service.IArticleService;
import com.blog.service.IBlogTypeService;
import com.blog.service.ICommentService;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.BlogTypeServiceImpl;
import com.blog.service.impl.CommentServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;

/**
 * @author lvconl
 * 类说明：处理与article相关servlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        IArticleService articleService = new ArticleServiceImpl();
        String param = request.getParameter("param");
        String addBlogParam = "add";
        if (addBlogParam.equals(param)) {
            String title = request.getParameter("title");
            String summary = request.getParameter("summary");
            String content = request.getParameter("content");
            String typeId = request.getParameter("typeId");
            if (articleService.addArticle(title, summary, content, typeId)) {
                response.sendRedirect("IndexServlet");
            } else {
                request.setAttribute("msg", "新增失败...");
                request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String param = request.getParameter("param");
        String detailParam = "detail";
        IArticleService articleService = new ArticleServiceImpl();
        if (detailParam.equals(param)) {
            String articleId = request.getParameter("articleId");
            IBlogTypeService blogTypeService = new BlogTypeServiceImpl();
            ICommentService commentService = new CommentServiceImpl();
            Article article = articleService.queryArticleById(articleId);
            articleService.formatArticleCreateDateToDay(article);
            BlogType blogType = blogTypeService.queryBlogTypeById(article.getTypeId());
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr == null) {
                currentPageStr = "1";
            }
            int currentPage = Integer.parseInt(currentPageStr);
            int pageSize = 10;
            List<Comment> comments = commentService.queryCommentByPageAndArticleId(articleId, currentPage, pageSize);
            CommentPage commentPage = new CommentPage();
            commentPage.setComment(comments);
            int totalCount = commentService.getTotalCount(articleId);
            if (totalCount % pageSize == 0) {
                commentPage.setTotalPage(totalCount / pageSize);
            } else {
                commentPage.setTotalPage(totalCount / pageSize + 1);
            }
            commentPage.setTotalCount(totalCount);
            commentPage.setPageSize(pageSize);
            commentPage.setCurrentPage(currentPage);
            request.setAttribute("comments", comments);
            request.setAttribute("commentPage", commentPage);
            request.setAttribute("article", article);
            request.setAttribute("blogType", blogType);
            request.getRequestDispatcher("WEB-INF/views/detail.jsp").forward(request, response);
        }
    }
}
