package com.zoop.service.impl;

import javax.annotation.Resource;

import com.zoop.dao.UserInfoDao;
import com.zoop.entity.UserInfo;
import com.zoop.service.TestService;

public class TestServiceImpl implements TestService{

	@Resource
	private UserInfoDao userInfoDao;
	
	public UserInfo getUserById(String id) {
		return userInfoDao.getUserById(id);
	}

}
