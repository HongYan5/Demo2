package com.lqh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lqh.entity.Role;

public interface RoleService {
	List<Role> getRoleList(Integer pageIndex,Integer pageSize);
	int getRoleListRows(Integer pageIndex,Integer pageSize);
	int getRole(String roleCode);
	int addRole(Role role);
	Role getRoleEntity(Integer id);
	int updateRole(Role role);
	int deleteRole(Integer id);
}
