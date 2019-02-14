package com.blog.servlet;

import com.blog.entity.BlogType;
import com.blog.entity.User;
import com.blog.service.IBlogTypeService;
import com.blog.service.IUserService;
import com.blog.service.impl.BlogTypeServiceImpl;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lvconl
 * 处理网站用户相关请求
 * */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String param = request.getParameter("param");
        String loginParam = "login";
        if (loginParam.equals(param)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User loginUser = new User(username, password);
            IUserService userService = new UserServiceImpl();
            User user = userService.login(loginUser);
            if (user != null) {
                IBlogTypeService blogTypeService = new BlogTypeServiceImpl();
                List<BlogType> blogTypes = blogTypeService.queryAllBlogType();
                request.setAttribute("blogTypes", blogTypes);
                request.getSession().setAttribute("userId", user.getId());
                request.setAttribute("title", "管理员主页");
                request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "账号或密码错误!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String param = request.getParameter("param");
        String loginParam = "login";
        if (loginParam.equals(param)) {
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
