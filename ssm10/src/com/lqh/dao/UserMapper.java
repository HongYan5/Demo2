package com.lqh.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.lqh.entity.Role;
import com.lqh.entity.User;

public interface UserMapper {
	List<Role> getRoleList();
	User getLoginUser(User entity);
	List<User> getUserList(@Param("userName") String userName,@Param("userRole")int userRole,@Param("currentPageNo") int currentPageNo,@Param("pageSize")  int pageSize);
	int getUserRows(@Param("userName") String userName,@Param("userRole") int userRole);
	User getUser(@Param("id") Integer id);
	int updateUser(User	user);
}
