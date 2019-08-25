package com.login.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.login.entity.User;
import com.login.service.impl.UserServiceImpl;


@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("userName") String userName,
			@RequestParam("password") String password,HttpSession session) {
		System.out.println(">>>>>进入ModelAndView函数,userName:"+userName+",password:"+password);

		int result=userService.login(userName, password);

		if (result==201) {// 用户名与密码匹配
			return new ModelAndView("redirect:/main.html");// 跳转至主页面
		} else {
			session.setAttribute("reason", result);
			return new ModelAndView("redirect:/index.jsp");// 返回初始页面
		}
	} 

	@RequestMapping(value="/check.action",method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String checkUserName(@RequestBody User model)
	{
		System.out.println(">>>>>进入checkUserName函数,传入的userName:"+model.getUserName());

		int result=userService.checkUserName(model.getUserName());
		if(result==1)
		{
			return new String("用户名可用");
		}else
		{
			return new String("用户名已被使用");
		}
	}

	@RequestMapping(value="/register.action",method=RequestMethod.POST)
	public ModelAndView register(User model, HttpSession session)
	{
		System.out.println(">>>>>进入register函数,传入的参数:"+model.getUserName()+","+ model.getPassword()+","
				+model.getCountry()+","+ model.getProvince()+","+ model.geturban()+","+ model.getAddress()+","
				+model.getPhoneNumber()+","+ model.getEmail());

		int checkResult=userService.checkUserName(model.getUserName());// 检查用户名是否存在
		if(checkResult==1)
		{// 用户名未被占用
			// 执行数据库插入操作
			int result=userService.register(model.getUserName(), model.getPassword(), 
					model.getCountry(), model.getProvince(), model.geturban(), model.getAddress(),
					model.getPhoneNumber(), model.getEmail());

			if(result==400)
			{
				return new ModelAndView("redirect:/index.jsp");// 注册成功，跳转至初始页面
			}else
			{
				session.setAttribute("reason", result);
				return new ModelAndView("redirect:/register.jsp");// 注册失败，返回注册页面
			}

		}else
		{// 用户名已被占用
			return new ModelAndView("redirect:/register.jsp");// 注册失败，返回注册页面
		}


	}
}