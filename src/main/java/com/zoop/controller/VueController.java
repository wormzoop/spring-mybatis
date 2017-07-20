package com.zoop.controller;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoop.entity.UserInfo;
import com.zoop.service.TestService;

@Controller
public class VueController {

	private static Logger logger = Logger.getLogger(TestController.class);
	
	@Autowired
	TestService testService;
	
	/**
	 * vue注册
	 * @param name 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "/register.do")
	@ResponseBody
	public String register(@RequestParam(value="name") String name, 
			@RequestParam(value="password") String password){
		if(name == null || password == null || name.equals("") || password.equals("")){
			return "0";
		}
		try{
			Random random = new Random();
			String id = String.valueOf(random.nextInt(10000));
			UserInfo user = new UserInfo(id, name, password);
			testService.register(user);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return "0";
		}
		return "1";
	}
	
	/**
	 * vue登录
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login.do")
	@ResponseBody
	public String login(@RequestParam(value="name") String name, 
			@RequestParam(value="password") String password){
		try{
			UserInfo user = new UserInfo();
			user.setName(name);
			user.setPassword(password);
			int count = testService.login(user);
			if(count == 0){
				return "0";
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return "0";
		}
		return "1";
	}
	
}
