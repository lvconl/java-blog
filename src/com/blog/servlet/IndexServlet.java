package com.blog.servlet;

import com.blog.entity.Article;
import com.blog.entity.ArticlePage;
import com.blog.entity.Leacot;
import com.blog.entity.LeacotPage;
import com.blog.service.IArticleService;
import com.blog.service.ILeacotService;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.LeacotServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lvconl
 *处理首页相关请求
 * */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String param = request.getParameter("param");
        String mainParam = "main";
        String leacotsParam = "leacots";
        String aboutParam = "about";
        if (param == null || mainParam.equals(param)) {
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr == null) {
                currentPageStr = "1";
            }
            int currentPage = Integer.parseInt(currentPageStr);
            int pageSize = 4;
            IArticleService articleService = new ArticleServiceImpl();
            ArticlePage articlePage = new ArticlePage();
            List<Article> articles = articleService.queryArticleByPage(currentPage, pageSize);
            articleService.formatArticlesCreateDateToHour(articles);
            int totalCount = articleService.getTotalCount();
            if (totalCount % pageSize == 0) {
                articlePage.setTotalPage(totalCount / pageSize);
            } else {
                articlePage.setTotalPage(totalCount / pageSize + 1);
            }
            articlePage.setCurrentPage(currentPage);
            articlePage.setArticles(articles);
            articlePage.setTotalCount(totalCount);
            articlePage.setPageSize(pageSize);
            request.setAttribute("articlePage", articlePage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (leacotsParam.equals(param)) {
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr == null) {
                currentPageStr = "1";
            }
            int currentPage = Integer.parseInt(currentPageStr);
            int pageSize = 1;
            ILeacotService leacotService = new LeacotServiceImpl();
            LeacotPage leacotPage = new LeacotPage();
            List<Leacot> leacots = leacotService.queryLeacotByPage(currentPage, pageSize);
            leacotService.replaceEmail(leacots);
            int totalCount = leacotService.getTotalCount();
            if (totalCount % pageSize == 0) {
                leacotPage.setTotalPage(totalCount / pageSize);
            } else {
                leacotPage.setTotalPage(totalCount / pageSize + 1);
            }
            leacotPage.setTotalCount(totalCount);
            leacotPage.setCurrentPage(currentPage);
            leacotPage.setPageSize(pageSize);
            request.setAttribute("leacotPage", leacotPage);
            request.setAttribute("leacots", leacots);
            request.getRequestDispatcher("WEB-INF/views/leacots.jsp").forward(request, response);
        }
        if (aboutParam.equals(param)) {
            request.getRequestDispatcher("WEB-INF/views/about.jsp").forward(request, response);
        }
    }
}
