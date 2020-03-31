package com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bean.CommonResult;
import com.bean.UserInfo;

public interface IUserInfoService {
	public CommonResult insert(UserInfo userInfo);

	public CommonResult deleteById(Integer id);
	
	public CommonResult findBySex(String sex);
	
	public CommonResult findBySex2(String sex);
	
	public CommonResult findByName(String sex);
	
	public CommonResult findByName2(String sex);

	public CommonResult findByName3(String sex);
	
	public CommonResult findAllPaging(Pageable pageable);

	public CommonResult findCustomBeanFromJoinQuery();

	public CommonResult saveAll(List<UserInfo> userList);

	public CommonResult save(UserInfo userInfo);

	public CommonResult updateNameById(Integer id, String name);
	
	public CommonResult updateById(UserInfo userInfo);

	public CommonResult addOne(UserInfo userInfo);
	
}
