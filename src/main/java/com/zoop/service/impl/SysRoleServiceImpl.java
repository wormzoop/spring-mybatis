package com.zoop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoop.daoother.SysRoleDao;
import com.zoop.entity.SysRole;
import com.zoop.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao; 
	
	@Override
	public List<SysRole> list() {
		return sysRoleDao.list();
	}

}
