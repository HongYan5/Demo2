package com.lqh.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.lqh.entity.Role;
import com.lqh.entity.User;
import com.lqh.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/jsp/rolelist.do")
	public String getBillList(@RequestParam(required=false) Integer pageIndex,Model model){
		if(pageIndex==null) pageIndex=1;
		System.out.println("sdf");
		List<Role> list=roleService.getRoleList((pageIndex-1)*5, 5);
		int count=roleService.getRoleListRows((pageIndex-1)*5, 5);
		model.addAttribute("roleList", list);
		model.addAttribute("totalPageCount", count%5==0?count/5:count/5+1);
		model.addAttribute("totalCount", count);
		model.addAttribute("currentPageNo", pageIndex);
		return "jsp/rolelist";
	}
	
	@RequestMapping("/jsp/roleAjax.do")
	@ResponseBody
	public String getRole(String roleCode,Model model){
		int count=roleService.getRole(roleCode);
		if(count>0){
			model.addAttribute("roleCode", "exist");
		}else{
			model.addAttribute("roleCode", "noexist");
		}
		return JSONArray.toJSONString(model);
	}
	
	@RequestMapping("jsp/addRole.do")
	public String addBill(Role role,HttpSession session){
		User user=(User)session.getAttribute("userSession");
		role.setCreatedBy(user.getId());
		role.setCreationDate(new Date());
		int count=roleService.addRole(role);
		if(count==1){
			return "redirect:/jsp/rolelist.do";
		}else{
			return "/jsp/roleadd";
		}
	}
	
	@RequestMapping("/jsp/getRole.do")
	public String getRole(int mode,Integer uid,Model model){
		Role role=roleService.getRoleEntity(uid);
		model.addAttribute("role", role);
		if(mode==0){
			return "/jsp/roleview";
		}else{
			return "/jsp/rolemodify";
		}
		
	}
	@RequestMapping("jsp/updateRole.do")
	public String updateRole(Role role,Model mode){
		int count=roleService.updateRole(role);
		if(count==0){
			mode.addAttribute("role", role);
			return "/jsp/rolemodify";
		}else{
			return "redirect:/jsp/rolelist.do";
		}
	}
	@RequestMapping("jsp/deleteRole.do")
	@ResponseBody
	public String updateRole(Integer id,Model mode){
		int count=roleService.deleteRole(id);
		if(count==0){
			mode.addAttribute("delResult", "false");
		}else{
			mode.addAttribute("delResult", "true");
		}	
		return JSONArray.toJSONString(mode);
	}
}
