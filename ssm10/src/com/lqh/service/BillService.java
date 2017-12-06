package com.lqh.service;

import java.util.List;
import com.lqh.entity.Bill;

public interface BillService {
	List<Bill> getBillList(Integer pageIndex,Integer pageSize,
			String queryProductName,Integer queryProviderId
			,Integer queryIsPayment);	
	int getBillRows(String queryProductName,Integer queryProviderId
			,Integer queryIsPayment);	
	int addBill(Bill bill);
	int updateBill(Bill bill);
	int deleteBill(Integer id);
	Bill getBill(Integer id);
}
