package com.zoop.service;

import java.util.List;

import com.zoop.entity.UserInfo;

public interface TestService {

	UserInfo getUserById(String id);
	
	List<UserInfo> geUserlist();
	
	void addUser(UserInfo user);
}
