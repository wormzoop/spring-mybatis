package com.zoop.daoother;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zoop.entity.SysRole;

@MapperScan
public interface SysRoleDao {

	List<SysRole> list();
	
}
