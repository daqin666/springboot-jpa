package com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.CommonResult;
import com.bean.UserInfo;
import com.dao.UserRepository;
import com.service.IUserInfoService;

//@Service
@Transactional
@Repository  
public class UserInfoServiceImpl implements IUserInfoService {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public CommonResult insert(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult deleteById(Integer id) {
		CommonResult result = new CommonResult();
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult findBySex(String sex) {
		CommonResult result = null;
		try {
			List<UserInfo> userInfoList = userRepository.findBySex(sex);
			result = new CommonResult(true, "成功", userInfoList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}

	@Override
	public CommonResult findBySex2(String sex) {
		CommonResult result = null;
		try {
			List<UserInfo> userInfoList = userRepository.findBySex2(sex);
			result = new CommonResult(true, "成功", userInfoList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}

	@Override
	public CommonResult findByName(String sex) {
		CommonResult result = null;
		try {
			List<UserInfo> userInfoList = userRepository.findByName(sex);
			result = new CommonResult(true, "成功", userInfoList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}

	@Override
	public CommonResult findByName2(String sex) {
		CommonResult result = null;
		try {
			List<UserInfo> userInfoList = userRepository.findByName2(sex);
			result = new CommonResult(true, "成功", userInfoList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}

	@Override
	public CommonResult findByName3(String sex) {
		CommonResult result = null;
		try {
			List<UserInfo> userInfoList = userRepository.findByName3(sex);
			result = new CommonResult(true, "成功", userInfoList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult findAllPaging(Pageable pageable) {
		CommonResult result = null;
		try {
			List<UserInfo> userInfoList = userRepository.findAllPaging(pageable);
			result = new CommonResult(true, "成功", userInfoList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult findCustomBeanFromJoinQuery() {
		CommonResult result = null;
		try {
			List<Object> object = userRepository.findCustomBeanFromJoinQuery();
			result = new CommonResult(true, "成功", object);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}

	@Override
	public CommonResult saveAll(List<UserInfo> userList) {
		CommonResult result = new CommonResult();
		try {
			userRepository.saveAll(userList);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult save(UserInfo userInfo) {
		CommonResult result = new CommonResult();
		try {
			userRepository.save(userInfo);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult updateNameById(Integer id, String name) {
		CommonResult result = new CommonResult();
		try {
			userRepository.updateNameById(id, name);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult updateById(UserInfo userInfo) {
		CommonResult result = new CommonResult();
		try {
			userRepository.updateById(userInfo);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public CommonResult addOne(UserInfo userInfo) {
		CommonResult result = new CommonResult();
		try {
			userRepository.addOne(userInfo);
		} catch (Exception e) {
			logger.error(e.toString());
			result.setState(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
}
