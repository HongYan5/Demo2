package com.lqh.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.lqh.entity.Bill;
import com.lqh.entity.Provider;
import com.lqh.entity.User;
import com.lqh.service.BillService;
import com.lqh.service.ProviderService;

@Controller
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired
	private ProviderService providerService;
	@RequestMapping("jsp/bill.do")
	public String getBillList(
			@RequestParam(required=false) Integer pageIndex,
			@RequestParam(required=false) String queryProductName,
			@RequestParam(required=false) Integer queryProviderId,
			@RequestParam(required=false) Integer queryIsPayment,Model model){
		if(pageIndex==null) pageIndex=1;
		if(queryProviderId==null) queryProviderId=0;
		if(queryIsPayment==null) queryIsPayment=0;
		List<Bill> list=billService.getBillList((pageIndex-1)*5, 5, queryProductName, queryProviderId, queryIsPayment);
		List<Provider> listPro=providerService.providerList();
		int count=billService.getBillRows(queryProductName, queryProviderId, queryIsPayment);
		model.addAttribute("providerList", listPro);
		model.addAttribute("queryProductName", queryProductName);
		model.addAttribute("queryProviderId", queryProviderId);
		model.addAttribute("queryIsPayment", queryIsPayment);
		model.addAttribute("billList", list);
		model.addAttribute("totalPageCount", count%5==0?count/5:count/5+1);
		model.addAttribute("totalCount", count);
		model.addAttribute("currentPageNo", pageIndex);
		return "jsp/billlist";
	}
	@RequestMapping("/jsp/getBill.do")
	public String getProvider(int mode,Integer billid,Model model){
		Bill bill=billService.getBill(billid);
		model.addAttribute("bill", bill);
		if(mode==0){
			return "jsp/billview";
		}else{
			return "jsp/billmodify";
		}
		
	} 
	
	@RequestMapping("/jsp/getproviderlist.do")
	@ResponseBody
	public List<Provider> getproviderlist(){
		return providerService.providerList();
	}
	@RequestMapping("/jsp/updateBill.do")
	public String updateBill(Bill bill){
		int count=billService.updateBill(bill);
		if(count==1){
			return "redirect:/jsp/bill.do";
		}else{
			return "/jsp/billmodify";
		}
	}
	@RequestMapping("jsp/deleteBill.do")
	@ResponseBody
	public Object deleteBill(int billid){
		int count=billService.deleteBill(billid);
		Map<String, String> map=new HashMap<String, String>();
		if(count==1){
			map.put("delResult", "true");
			
		}else{
			map.put("delResult", "false");
			
		}
		return JSONArray.toJSONString(map);
	}
	
	@RequestMapping("jsp/addBill.do")
	public String addBill(Bill bill,HttpSession session){
		User user=(User)session.getAttribute("userSession");
		bill.setCreatedBy(user.getId());
		bill.setCreationDate(new Date());
		int count=billService.addBill(bill);
		if(count==1){
			return "redirect:/jsp/bill.do";
		}else{
			return "/jsp/addbill";
		}
	}
}
