package com.lqh.service.impl;

import java.util.List;
import com.lqh.dao.BillMapper;
import com.lqh.entity.Bill;
import com.lqh.service.BillService;

public class BillServiceImpl implements BillService{
	
	private BillMapper billMapper;
	public BillMapper getBillMapper() {
		return billMapper;
	}

	public void setBillMapper(BillMapper billMapper) {
		this.billMapper = billMapper;
	}

	@Override
	public List<Bill> getBillList(Integer pageIndex, Integer pageSize,
			String queryProductName, Integer queryProviderId,
			Integer queryIsPayment) {
		// TODO Auto-generated method stub
		return billMapper.getBillList(pageIndex, pageSize, queryProductName, queryProviderId, queryIsPayment);
	}

	@Override
	public int getBillRows(String queryProductName, Integer queryProviderId,
			Integer queryIsPayment) {
		// TODO Auto-generated method stub
		return billMapper.getBillRows(queryProductName, queryProviderId, queryIsPayment);
	}

	@Override
	public int addBill(Bill bill) {
		// TODO Auto-generated method stub
		return billMapper.addBill(bill);
	}

	@Override
	public int updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return billMapper.updateBill(bill);
	}

	@Override
	public int deleteBill(Integer id) {
		// TODO Auto-generated method stub
		return billMapper.deleteBill(id);
	}

	@Override
	public Bill getBill(Integer id) {
		// TODO Auto-generated method stub
		return billMapper.getBill(id);
	}

}
