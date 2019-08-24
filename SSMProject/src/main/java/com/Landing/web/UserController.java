package com.Landing.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Landing.dao.UserDao;
import com.Landing.entity.User;



/**
 * �û�������
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	private UserDao userDao;

	@RequestMapping("/view")
	public String view() {
		return "main/login";
	}

	@RequestMapping("/indexview")
	public String index() {
		return "main/index";
	}

	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public ModelAndView login(User model, HttpSession session) {
		User user = userDao.findByUsername(model.getUsername());

		if (user == null || !user.getPassword().equals(model.getPassword())) {
			System.out.println(">>>>>进入ModelAndView函数，输入错误，sessionID:"+session.getId());
			return new ModelAndView("redirect:/index.jsp");
		} else {
			System.out.println(">>>>>进入ModelAndView函数，输入正确，sessionID:"+session.getId());

			session.setAttribute("username", user.getUsername());
			return new ModelAndView("redirect:/login.jsp");
		}
	}
}