package com.login.service;

public interface UserService {
	public int login(String userName, String password);//参数为string，可以为userName, email, phoneNumber

	public int register( String userName, String password, String country, 
			String province, String urban,String address, String phoneNumber, String email);

	public int checkUserName(String userName);
}

