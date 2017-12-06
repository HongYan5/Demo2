package com.lqh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lqh.entity.Provider;
import com.lqh.service.ProviderService;

@Controller
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("jsp/provider.do")
	public String getProviderList(
			@RequestParam(required=false) Integer pageIndex,
			@RequestParam(required=false) String queryProCode,
			@RequestParam(required=false) String queryProName,Model model){
		if(pageIndex==null) pageIndex=1;
		List<Provider> list= providerService.getProviderList((pageIndex-1)*5, 5, queryProCode, queryProName);
		int count=providerService.getProviderRows(queryProCode, queryProName);
		model.addAttribute("queryProCode", queryProCode);
		model.addAttribute("queryProName", queryProName);
		model.addAttribute("providerList", list);
		model.addAttribute("totalPageCount", count%5==0?count/5:count/5+1);
		model.addAttribute("totalCount", count);
		model.addAttribute("currentPageNo", pageIndex);
		return "jsp/providerlist";
	}
	
	@RequestMapping("/jsp/getprovider.do")
	public String getProvider(int mode,Integer proid,Model model){
		Provider provider=providerService.getProvider(proid);
		model.addAttribute("provider", provider);
		if(mode==0){
			return "jsp/providerview";
		}else{
			return "jsp/providermodify";
		}
		
	}
	
	//更新
	@RequestMapping("/jsp/providerModify.do")
	public String updateProvider(Provider provider,Model model){
		int count=providerService.updateProvider(provider);
		if(count==0){
			model.addAttribute("provider", provider);
			return "jsp/providermodify";
		}else{
			return "redirect:jsp/provider.do";
		}
		
	}
	
	@RequestMapping("/jsp/providerDelete.do")
	public String deleteProvider(Integer proid,Model model){
		int count=providerService.deleteProvider(proid);
		if(count==0){
			model.addAttribute("stuta", "删除失败");
		}else{
			model.addAttribute("stuta", "删除成功");
		}
		return "redirect:jsp/provider.do";
	}
	

}
