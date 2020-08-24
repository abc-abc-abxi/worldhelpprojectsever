package cn.server.Servlet;

import cn.server.Utils.Util_Druid;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");//获取客户端传来的用户名和密码
        String password=req.getParameter("password");
        String logininfo;
        Boolean flag=false;
        flag=connectdatebase(username,password);
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


    }
    public boolean connectdatebase(String username,String password)//查询数据库看是否有对应用户名和密码
    {
        Connection con=null;
        PreparedStatement pre=null;
        ResultSet result=null;
        boolean flag2=false;
        try {
            String sql="select * from userhelp where username = ?and password=?";
               con= Util_Druid.getConnection();
               pre=con.prepareStatement(sql);
               pre.setString(1,username);
               pre.setString(2,password);
               result=pre.executeQuery();
               if (result.next())
               {
                   flag2=true;
               }
               else {
                   flag2=false;
               }



        }catch (Exception e)
        {
            e.printStackTrace();
        } finally {
          Util_Druid.close(result,pre,con);
        }
        return flag2;
    }
}
