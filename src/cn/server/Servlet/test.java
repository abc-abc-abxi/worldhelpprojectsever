package cn.server.Servlet;

import cn.server.Utils.Util_Druid;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class test {

    //JdbcTemplate 操作数据库连接池对象
    private JdbcTemplate temp = new JdbcTemplate(Util_Druid.getDataSource());

    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        String sql = "select * from userhelp where id = ?";
        //queryForMap查询出来的结果 只能是一行数据 （列名为key,数据为value）
        Map<String, Object> map = temp.queryForMap(sql, 1);
        System.out.println(map);
    }
}
