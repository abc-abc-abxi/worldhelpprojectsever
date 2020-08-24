package cn.server.Servlet;

import cn.server.Utils.Util_Druid;
import cn.server.Utils.informationadd;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class Database_method {

    public static void main(String[] args) {
        Database_method method = new Database_method();
        int i = method.SetUser(2,"22","男","44","11");
        int j = 0;
        if (i==1){//得到返回值i为1的话就存到数据库
            j = method.InsertUser();
            System.out.println("存入封装类成功");
        }else System.out.println("存在此手机号,存入封装类失败");

        if (j==1){
            System.out.println("存入数据库成功");
        }else System.out.println("存入数据库失败");
    }

    //封装类 存放的是用户信息
    private informationadd informat = new informationadd();
    //JdbcTemplate 操作数据库连接池对象
    private JdbcTemplate temp = new JdbcTemplate(Util_Druid.getDataSource());


    //先将用户的信息存储到封装类里，返回0就是没存入封装类里，返回1就是存到了封装类
    public int SetUser(int id,String username,String sex ,String date,String password){
        //如果id不空
        if (id != 0){
           String sql = "select * from userhelp where id = ?";
            //查询数据库中有没有相同的手机号,没有会出现异常情况 执行catch里面的代码,即存入封装类 然后继续执行
           try{
               Map<String, Object> map = temp.queryForMap(sql,id);
           }catch (EmptyResultDataAccessException e ) {

               informat.setId(id);//手机号放入封装类
               System.out.println("没有此手机号，可以存入封装类");
               if (username != null && sex != null && date != null) {
                   informat.setUsername(username);//将昵称放入封装类中
                   informat.setSex(sex);//将性别放入封装类
                   informat.setDate(date);//将日期放入类中
                   informat.setPassword(password);//将密码放入类中
                   return 1;
               }else {
                   System.out.println("昵称、性别或者日期 存在空值");
                   return 0;
               }
           }
       }
        //判断第一次输入密码和第二次输入密码是否相同,这个在客户端完成就可以
        return 0;
    }

    //将设置好的封装类加入数据库表中，返回执行条数若是为0就是没存入数据库，返回1就是加入成功了
    public int InsertUser(){
        String sql = "insert  into userhelp(id,username,sex,date,password) value(?,?,?,?,?)";
        int update = temp.update(sql, informat.getId(), informat.getUsername(), informat.getSex(), informat.getDate(), informat.getPassword());
        return update;
    }


}
