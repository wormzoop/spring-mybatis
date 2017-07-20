package com.zoop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zoop.dao.UserInfoDao;
import com.zoop.entity.UserInfo;
import com.zoop.service.TestService;

public class TestServiceImpl implements TestService{

	@Resource
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfo getUserById(String id) {
		return userInfoDao.getUserById(id);
	}

	@Override
	public List<UserInfo> geUserlist() {
		return userInfoDao.userList();
	}

	@Override
	public void addUser(UserInfo user) {
		userInfoDao.addUser(user);
	}

	/*
	 * vue用户注册
	 */
	@Override
	public void register(UserInfo user) {
		userInfoDao.register(user);
	}

	/*
	 * vue登录验证
	 */
	@Override
	public Integer login(UserInfo user) {
		return userInfoDao.login(user);
	}
	
}
