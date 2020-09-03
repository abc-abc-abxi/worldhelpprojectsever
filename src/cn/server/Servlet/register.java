package cn.server.Servlet;

import cn.server.Utils.infoinsert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String date=req.getParameter("date");
        String sex=req.getParameter("sex");
        String phonenumber=req.getParameter("phonenumber");

        infoinsert infoinsert1=new infoinsert();
        int result=infoinsert1.SetUser(phonenumber,username,sex,date,password);
        if(result==0)
        {
         out.write("false");
        }
        else
        {
            infoinsert1.InsertUser();
            out.write("successful");
        }

    }
}
