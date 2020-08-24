package cn.server.Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/ServletDemo")
public class servlet1 implements Servlet {
    /**
     * 初始化 在创建Servlet时只执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("调用--------init");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 每访问一次就执行一次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("调用--------service");
            System.out.println("servlet 测试成功 ");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 服务器关闭后调用一次
     */
    @Override
    public void destroy() {
        System.out.println("调用--------destroy");

    }
}
