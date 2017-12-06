package com.lqh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lqh.entity.Role;

public interface RoleMapper {
	List<Role> getRoleList(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	int getRoleListRows(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	int getRole(String roleCode);
	int addRole(Role role);
	Role getRoleEntity(@Param("id") Integer id);
	int updateRole(Role role);
	int deleteRole(@Param("id") Integer id);
}
