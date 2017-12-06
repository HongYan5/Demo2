package com.lqh.service.impl;

import java.util.List;

import com.lqh.dao.RoleMapper;
import com.lqh.entity.Role;
import com.lqh.service.RoleService;

public class RoleServiceImpl implements RoleService{
	private RoleMapper roleMapper;
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public List<Role> getRoleList(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleList(pageIndex, pageSize);
	}
	@Override
	public int getRoleListRows(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleListRows(pageIndex, pageSize);
	}
	@Override
	public int getRole(String roleCode) {
		// TODO Auto-generated method stub
		return roleMapper.getRole(roleCode);
	}
	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.addRole(role);
	}
	@Override
	public Role getRoleEntity(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleEntity(id);
	}
	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRole(role);
	}
	@Override
	public int deleteRole(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRole(id);
	}

}
