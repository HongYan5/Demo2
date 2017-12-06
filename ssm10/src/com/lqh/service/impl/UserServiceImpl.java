package com.lqh.service.impl;

import java.util.List;

import com.lqh.dao.UserMapper;
import com.lqh.entity.Role;
import com.lqh.entity.User;
import com.lqh.service.UserService;

public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public User getLoginUser(User entity) {
		// TODO Auto-generated method stub
		return userMapper.getLoginUser(entity);
	}
	@Override
	public List<User> getUserList(String userName, int userRole,
			int currentPageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserList(userName, userRole, currentPageNo, pageSize);
	}
	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return userMapper.getRoleList();
	}
	@Override
	public int getUserRows(String userName, int userRole) {
		// TODO Auto-generated method stub
		return userMapper.getUserRows(userName, userRole);
	}
	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUser(id);
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}
	 
}
