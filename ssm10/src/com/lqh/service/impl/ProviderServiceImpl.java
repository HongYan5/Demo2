package com.lqh.service.impl;

import java.util.List;

import com.lqh.dao.ProviderMapper;
import com.lqh.entity.Provider;
import com.lqh.service.ProviderService;

public class ProviderServiceImpl implements ProviderService{
	private ProviderMapper providerMapper;
	public ProviderMapper getProviderMapper() {
		return providerMapper;
	}
	public void setProviderMapper(ProviderMapper providerMapper) {
		this.providerMapper = providerMapper;
	}
	
	@Override
	public List<Provider> getProviderList(Integer pageIndex, Integer pageSize,
			String proCode, String proName) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderList(pageIndex, pageSize, proCode, proName);
	}
	@Override
	public Provider getProvider(Integer id) {
		// TODO Auto-generated method stub
		return providerMapper.getProvider(id);
	}
	@Override
	public int updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapper.updateProvider(provider);
	}
	@Override
	public int deleteProvider(Integer id) {
		// TODO Auto-generated method stub
		return providerMapper.deleteProvider(id);
	}
	@Override
	public int getProviderRows(String proCode, String proName) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderRows(proCode, proName);
	}
	@Override
	public List<Provider> providerList() {
		// TODO Auto-generated method stub
		return providerMapper.providerList();
	}

}
