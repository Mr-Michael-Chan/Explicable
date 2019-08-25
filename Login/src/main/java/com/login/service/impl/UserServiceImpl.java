package com.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.login.entity.User;
import com.login.service.UserService;
import com.login.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public int login(String userName, String password) {
		System.out.println(">>>>>进入login函数");
		User result = userDao.findByUserName(userName);

		if (result == null) {
			return 200;// 用户不存在
		} else {
			if (password.equals(result.getPassword())) {
				return 201;// 登录成功
			} else {
				return 202;// 密码错误
			}
		}
	}

	// 实现用户注册操作
	public int register( String userName, String password, String country, String province, String urban,
			String address, String phoneNumber, String email) {
		User result = userDao.findByUserName(userName);// 首先判断是否存在使用该用户名的用户

		if (result == null) {
			boolean flag = userDao.insertOneUser( userName, password, country, province, 
					urban, address, phoneNumber,email);

			if (flag) {
				return 400;// 注册成功
			} else {
				return 401;// 数据库插入失败
			}
		} else {
			return 402;// 用户名已存在
		}
	}

	// 检查用户名是否已存在
	public int checkUserName(String userName){
		User result = userDao.findByUserName(userName);

		if (result == null) {
			return 1; // 用户名未使用
		} else {
			return 0; //用户名已使用
		}
	}

}