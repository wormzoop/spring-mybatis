package com.zoop.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zoop.entity.UserInfo;

@MapperScan
public interface UserInfoDao {

	List<UserInfo> userList();
	
	UserInfo getUserById(String id);
	
	void addUser(UserInfo user);
	
	/*
	 * vue用户注册
	 */
	void register(UserInfo user);
	
	Integer login(UserInfo user);
	
}
