package com.lqh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lqh.entity.Provider;

public interface ProviderService {
	List<Provider> getProviderList(Integer pageIndex,Integer pageSize,String proCode,String proName);
	Provider getProvider(@Param("id") Integer id);
	int updateProvider(Provider provider);
	int deleteProvider(Integer id);
	int getProviderRows(String proCode,String proName);
	List<Provider> providerList();
}
