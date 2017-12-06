package com.lqh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lqh.entity.Role;
import com.lqh.entity.User;

public interface UserService {
	User getLoginUser(User entity);
	List<User> getUserList(String userName,int userRole,int currentPageNo,int pageSize)throws Exception;
	List<Role> getRoleList();
	int getUserRows(String userName,int userRole);
	User getUser(@Param("id") Integer id);
	int updateUser(User	user);
}
