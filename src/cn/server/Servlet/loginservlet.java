package cn.server.Servlet;

import cn.server.Utils.serch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");//获取客户端传来的用户名和密码
        String password=req.getParameter("password");
        String logininfo;
        Boolean flag=false;
        flag= serch.connectdatebase(username,password);
        if(flag)
        {
            logininfo="success";
        }
        else
        {
            logininfo="fail";
        }
        PrintWriter out=resp.getWriter();
        out.write(logininfo);//向客户端返回登录成功或失败信息；
        System.out.println("successful");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


}
