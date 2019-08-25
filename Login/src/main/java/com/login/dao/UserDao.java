package com.login.dao;

import org.apache.ibatis.annotations.Param;

import com.login.entity.User;

public interface UserDao {
	public abstract User findByUserName(String userName);

	public abstract boolean insertOneUser( @Param("userName")String userName, 
			@Param("password")String password, @Param("country")String country, @Param("province")String province,
			@Param("urban")String urban,@Param("address")String address, @Param("phoneNumber")String phoneNumber,
			@Param("email")String email);
}
