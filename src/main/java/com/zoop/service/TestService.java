package com.zoop.service;

import java.util.List;

import com.zoop.entity.UserInfo;

public interface TestService {

	UserInfo getUserById(String id);
	
	List<UserInfo> geUserlist();
	
	void addUser(UserInfo user);
	
	/*
	 * vue用户注册
	 */
	void register(UserInfo user);
	
	/*
	 * vue登录验证
	 */
	Integer login(UserInfo user);
	
}
