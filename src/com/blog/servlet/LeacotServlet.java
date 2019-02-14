package com.blog.servlet;

import com.blog.service.ILeacotService;
import com.blog.service.impl.LeacotServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lvconl
 * 类说明：处理留言相关请求
 * */
@WebServlet("/LeacotServlet")
public class LeacotServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String param = request.getParameter("param");
        String addParam = "add";
        if (addParam.equals(param)) {
            String email = request.getParameter("email");
            String content = request.getParameter("content");
            ILeacotService leacotService = new LeacotServiceImpl();
            if (leacotService.addLeacot(email, content)) {
                response.sendRedirect("IndexServlet?param=leacots");
            } else {
                response.sendRedirect("404.jsp");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
