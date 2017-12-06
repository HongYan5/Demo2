package com.lqh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lqh.entity.Provider;

public interface ProviderMapper {
	List<Provider> getProviderList(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,
			@Param("proCode") String proCode,@Param("proName") String proName);
	Provider getProvider(@Param("id") Integer id);
	int updateProvider(Provider provider);
	int deleteProvider(@Param("id") Integer id);
	int getProviderRows(@Param("proCode") String proCode,@Param("proName") String proName);
	List<Provider> providerList();
}
