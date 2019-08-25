package com.login.entity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.login.dao")
public class User {
	private Integer id;
	private String userName;// 公司名称
	private String password;// 密码
	private String country; // 国家
	private String province; // 省
	private String urban;// 市
	private String address;// 详细地址ַ
	private String phoneNumber; // 联系方式
	private String email;// 电子邮件
	private String state;// 账号状态״̬

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String geturban() {
		return urban;
	}

	public void seturban(String urban) {
		this.urban = urban;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}

	public User(Integer id, String userName, String password, String country, String province, String urban,
			String address, String phoneNumber, String email, String state) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.country = country;
		this.province = province;
		this.urban = urban;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.state = state;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
