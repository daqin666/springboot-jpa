package com.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.CommonResult;
import com.bean.UserInfo;
import com.service.IUserInfoService;

@RestController
public class HelloController {
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello Spring Boot";
	}

	@RequestMapping("/hello1")
	public JSONObject hello1() {
		JSONObject temp = new JSONObject();
		temp.put("hello1", "hello Spring Boot");
		return temp;
	}
	
	@RequestMapping(value="/hello2", method=RequestMethod.POST)
	public JSONObject hello2(@RequestBody JSONObject info) {
		JSONObject temp = new JSONObject();
		temp.put("hello2", info.getString("hello2"));
		return temp;
	}
	
	@RequestMapping(value="/deleteById", method=RequestMethod.POST)
	public CommonResult deleteById(@RequestBody JSONObject info) {
		CommonResult result = userInfoService.deleteById(info.getInteger("id"));
		return result;
	}
	
	@RequestMapping(value="/findBySex", method=RequestMethod.POST)
	public CommonResult findBySex(@RequestBody JSONObject info) {
		CommonResult result = userInfoService.findBySex(info.getString("sex"));
		return result;
	}
	
	@RequestMapping(value="/findBySex2", method=RequestMethod.POST)
	public CommonResult findBySex2(@RequestBody JSONObject info) {
		CommonResult result = userInfoService.findBySex2(info.getString("sex"));
		return result;
	}
	
	@RequestMapping(value="/findByName", method=RequestMethod.POST)
	public CommonResult findByName(@RequestBody JSONObject info) {
		CommonResult result = userInfoService.findByName(info.getString("name"));
		return result;
	}
	
	@RequestMapping(value="/findByName2", method=RequestMethod.POST)
	public CommonResult findByName2(@RequestBody JSONObject info) {
		CommonResult result = userInfoService.findByName2(info.getString("name"));
		return result;
	}
	
	@RequestMapping(value="/findByName3", method=RequestMethod.POST)
	public CommonResult findByName3(@RequestBody JSONObject info) {
		CommonResult result = userInfoService.findByName3(info.getString("name"));
		return result;
	}
	
	@RequestMapping(value="/findAllPaging", method=RequestMethod.POST)
	public CommonResult findAllPaging(@RequestBody JSONObject info) {
		Integer pageNum = info.getInteger("pageNum");
		Integer pageSize = info.getInteger("pageSize");
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		Pageable pageable = new PageRequest(pageNum, pageSize, sort);
		CommonResult result = userInfoService.findAllPaging(pageable);
		return result;
	}
	
	@RequestMapping(value="/findCustomBeanFromJoinQuery", method=RequestMethod.POST)
	public CommonResult findCustomBeanFromJoinQuery() {
		CommonResult result = userInfoService.findCustomBeanFromJoinQuery();
		return result;
	}
	
	@RequestMapping(value="/saveAll", method=RequestMethod.POST)
	public CommonResult saveAll(@RequestBody JSONArray infoArray) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		if(infoArray != null && infoArray.size() >1) {
			for(int i = 0; i < infoArray.size(); i++) {
				JSONObject info = infoArray.getJSONObject(i);
				UserInfo userInfo = new UserInfo();
				userInfo.setName(info.getString("name"));
				userInfo.setAge(info.getInteger("age"));
				userInfo.setSex(info.getString("sex"));
				userList.add(userInfo);
			}
		}
		CommonResult result = userInfoService.saveAll(userList);
		return result;
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public CommonResult save(@RequestBody JSONObject info) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(info.getString("name"));
		userInfo.setAge(info.getInteger("age"));
		userInfo.setSex(info.getString("sex"));
		CommonResult result = userInfoService.save(userInfo);
		return result;
	}
	
	@RequestMapping(value="/updateNameById", method=RequestMethod.POST)
	public CommonResult updateNameById(@RequestBody JSONObject info) {
		Integer id = info.getInteger("id");
		String name = info.getString("name");
		CommonResult result = userInfoService.updateNameById(id, name);
		return result;
	}
	
	@RequestMapping(value="/updateById", method=RequestMethod.POST)
	public CommonResult updateById(@RequestBody JSONObject info) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(info.getInteger("id"));
		userInfo.setName(info.getString("name"));
		userInfo.setAge(info.getInteger("age"));
		userInfo.setSex(info.getString("sex"));
		CommonResult result = userInfoService.updateById(userInfo);
		return result;
	}
	
	@RequestMapping(value="/addOne", method=RequestMethod.POST)
	public CommonResult addOne(@RequestBody JSONObject info) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(info.getString("name"));
		userInfo.setAge(info.getInteger("age"));
		userInfo.setSex(info.getString("sex"));
		CommonResult result = userInfoService.addOne(userInfo);
		return result;
	}
	
	
//	@RequestMapping(value="/addUserBatch", method=RequestMethod.POST)
//	public String addUserBatch(@RequestBody JSONArray infoArray) {
//		List<UserInfo> userList = new ArrayList<UserInfo>();
//		for(int i = 0; i < infoArray.size(); i++) {
//			JSONObject info = infoArray.getJSONObject(i);
//			UserInfo userInfo = new UserInfo();
//			userInfo.setName(info.getString("name"));
//			userInfo.setAge(info.getInteger("age"));
//			userInfo.setSex(info.getString("sex"));
//			userList.add(userInfo);
//		}
//		String result = userInfoService.insertBatch(userList);
//		return result;
//	}
//	
//	@RequestMapping(value="/updateByName", method=RequestMethod.POST)
//	public String updateByName(@RequestBody JSONObject info) {
//		UserInfo userInfo = new UserInfo();
//		userInfo.setName(info.getString("name"));
//		userInfo.setAge(info.getInteger("age"));
//		userInfo.setSex(info.getString("sex"));
//		String result = userInfoService.updateByName(userInfo);
//		return result;
//	}
//	
//	@RequestMapping(value="/updateOneColByIdBatch", method=RequestMethod.POST)
//	public String updateOneColByIdBatch(@RequestBody JSONArray infoArray) {
//		List<UserInfo> userList = new ArrayList<UserInfo>();
//		for(int i = 0; i < infoArray.size(); i++) {
//			JSONObject info = infoArray.getJSONObject(i);
//			UserInfo userInfo = new UserInfo();
//			userInfo.setId(info.getInteger("id"));
//			userInfo.setName(info.getString("name"));
//			userInfo.setAge(info.getInteger("age"));
//			userInfo.setSex(info.getString("sex"));
//			userList.add(userInfo);
//		}
//		String result = userInfoService.updateOneColByIdBatch(userList);
//		return result;
//	}
//	
//	@RequestMapping(value="/updateColsByIdBatch", method=RequestMethod.POST)
//	public String updateColsByIdBatch(@RequestBody JSONArray infoArray) {
//		List<UserInfo> userList = new ArrayList<UserInfo>();
//		for(int i = 0; i < infoArray.size(); i++) {
//			JSONObject info = infoArray.getJSONObject(i);
//			UserInfo userInfo = new UserInfo();
//			userInfo.setId(info.getInteger("id"));
//			userInfo.setName(info.getString("name"));
//			userInfo.setAge(info.getInteger("age"));
//			userInfo.setSex(info.getString("sex"));
//			userList.add(userInfo);
//		}
//		String result = userInfoService.updateColsByIdBatch(userList);
//		return result;
//	}
//
//	@RequestMapping(value="/updateOneColByIdList", method=RequestMethod.POST)
//	public String updateOneColByIdList(@RequestBody JSONObject info) {
//		Map<String, String> nameIdMap = new HashMap<String, String>();
//		JSONArray idArray = info.getJSONArray("idList");
//		String idListStr = idArray.toString().replace("[", "").replace("]", "");
//		nameIdMap.put("name", info.getString("name"));
//		nameIdMap.put("idListStr", idListStr);
//		String result = userInfoService.updateOneColByIdList(nameIdMap);
//		return result;
//	}
//	
//	@RequestMapping(value="/deleteByIdBatch", method=RequestMethod.POST)
//	public String deleteByIdBatch(@RequestBody JSONObject info) {
//		JSONArray ids = info.getJSONArray("idList");
//		String result = null;
//		Integer[] idArray = null;
//		if(ids != null && ids.size() > 0) {
//			idArray = new Integer[ids.size()];
//			for(int i = 0; i < ids.size(); i++) {
//				idArray[i] = ids.getInteger(i);
//			}
//		}
//		result = userInfoService.deleteByIdBatch(idArray);
//		return result;
//	}
//	
//	@RequestMapping(value="/deleteByIdListBatch", method=RequestMethod.POST)
//	public String deleteByIdListBatch(@RequestBody JSONObject info) {
//		String result = null;
//		JSONArray ids = info.getJSONArray("idList");
//		if(ids != null && ids.size() > 0) {
//			List<Integer> idList = JSONObject.parseArray(ids.toJSONString(), Integer.class);
//			result = userInfoService.deleteByIdListBatch(idList);
//		}
//		return result;
//	}
}
