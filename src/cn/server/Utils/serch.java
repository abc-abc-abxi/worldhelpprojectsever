package cn.server.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class serch {
    public static boolean connectdatebase(String username,String password)
    {
        Connection con=null;
        PreparedStatement pre=null;
        ResultSet result=null;
        boolean flag2=false;
        try {
            String sql="select * from userinfo where username = ? and password = ?";
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
