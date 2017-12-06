package com.lqh.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.lqh.entity.Bill;

public interface BillMapper {
	List<Bill> getBillList(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,
			@Param("queryProductName") String queryProductName,@Param("queryProviderId") Integer queryProviderId
			,@Param("queryIsPayment") Integer queryIsPayment);	
	int getBillRows(@Param("queryProductName") String queryProductName,@Param("queryProviderId") Integer queryProviderId
			,@Param("queryIsPayment") Integer queryIsPayment);	
	int addBill(Bill bill);
	int updateBill(Bill bill);
	int deleteBill(@Param("id") Integer id);
	Bill getBill(@Param("id") Integer id);
}
