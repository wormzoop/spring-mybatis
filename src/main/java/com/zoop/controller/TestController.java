package com.zoop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoop.entity.UserInfo;
import com.zoop.service.TestService;

@Controller
public class TestController {

	private static Logger logger = Logger.getLogger(TestController.class);
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/test.do")
	@ResponseBody
	public String test(){
		System.out.println("---------------------------------jianjian");
		logger.info("/test.do");
		logger.error("test_error");
		return "jian";
	}
	
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public List<Map<String, Object>> returnList(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		Map<String, Object> m2 = new HashMap<String, Object>();
		m1.put("id", "11");
		m1.put("name", "jian");
		m2.put("id", "22");
		m2.put("name", "kang");
		list.add(m1);
		list.add(m2);
		return list;
	}
	
	@RequestMapping(value = "/getUserId.do")
	@ResponseBody
	public UserInfo getUserInfoById(@RequestParam(value="id") String id){
		UserInfo user = (UserInfo)testService.getUserById(id);
		return user;
	}
	
	@RequestMapping(value = "/getUserList.do")
	@ResponseBody
	public List<UserInfo> getUserList(){
		return testService.geUserlist();
	}
	
	@RequestMapping(value = "/insertUser.do")
	@ResponseBody
	public String insertUser(){
		UserInfo user = new UserInfo("111","111name","jiji");
		try{
			testService.addUser(user);
			return "SUCCESS";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ERROR";
	}
	
}
