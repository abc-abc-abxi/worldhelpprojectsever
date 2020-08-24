package cn.server.Utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Util_Druid {
    private static DataSource ds ;

    static {
        try {
            //1.创建配置文件对象
            Properties pro = new Properties();
            //2.加载配置文件
            InputStream in = Util_Druid.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            //3.创建DataSource 连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //4.创建连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //返回DateSource连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    //5.释放资源
    public static void close(ResultSet result, Statement state , Connection conn){
        if (result != null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
