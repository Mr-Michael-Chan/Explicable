package com.Landing.entity;

/**
 * �û���Ϣ
 */
public class User {
    // ��Ա����
    private Integer userid;
    private String username;
    private String password;

    // ���캯��
    public User() {
        super();
    }

    public User(Integer userid, String username, String password) {
        super();
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    // ��Ա����
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

