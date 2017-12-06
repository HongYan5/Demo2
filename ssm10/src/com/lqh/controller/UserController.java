package com.lqh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lqh.entity.Role;
import com.lqh.entity.User;
import com.lqh.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("login.do")
	public String login(String userCode,String userPassword,HttpSession session){
		User user=userService.getLoginUser(new User(userCode, userPassword));
		if(user!=null){
			session.setAttribute("userSession", user);
			return "/jsp/frame";
		}else{
			return "/login";
		}
	}
	
	@RequestMapping("jsp/user.do")
	public String userList(@RequestParam(required=false) Integer pageIndex,
			@RequestParam(required=false)  String queryname,
			@RequestParam(required=false) Integer queryUserRole,HttpServletRequest request){
		if(pageIndex==null) pageIndex=1;
		if(queryname==null) queryname="";
		if(queryUserRole==null)queryUserRole=0;
		try {
			List<Role> listRole=userService.getRoleList();
			List<User> list=userService.getUserList(queryname, queryUserRole, 5*(pageIndex-1), 5);
			int count=userService.getUserRows(queryname, queryUserRole);
			request.getSession().setAttribute("userList", list);
			request.getSession().setAttribute("queryUserName", queryname);
			request.getSession().setAttribute("queryUserRole", queryUserRole);
			request.getSession().setAttribute("roleList", listRole);
			request.getSession().setAttribute("totalPageCount", count/5==0?count/5:count/5+1);
			request.getSession().setAttribute("totalCount", count);
			request.getSession().setAttribute("currentPageNo", pageIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/userlist";
	}
	
	@RequestMapping("/jsp/getUser.do")
	public String getUser(int mode,Integer uid,Model model){
		User user=userService.getUser(uid);
		model.addAttribute("user", user);
		if(mode==0){
			return "/jsp/userview";
		}else{
			List<Role> listRole=userService.getRoleList();
			model.addAttribute("userList", listRole);
			return "/jsp/usermodify";
		}
	}
}
