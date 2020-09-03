package cn.server.Utils;

public class informationadd {

    private String phonenumber;//手机号
    private String username;//昵称
    private String sex;//性别
    private String date;//出生日期
    private String password;//密码

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setId(String id) {
        this.phonenumber = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "informationadd{" +
                "phonenumber=" + phonenumber +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", date='" + date + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
