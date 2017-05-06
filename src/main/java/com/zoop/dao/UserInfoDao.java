package com.zoop.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zoop.entity.UserInfo;

@MapperScan
public interface UserInfoDao {

	List<UserInfo> userList();
	
	UserInfo getUserById(String id);
	
}
