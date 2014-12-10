package com.lin.clould.module.main.service.impl;

import java.util.List;
import java.util.Map;

import com.lin.clould.module.main.service.MainService;

public class MainServiceImpl implements MainService {

	MainDAO mainDAO = new MainDAO();
	
	@Override
	public List<?> mainNoticeList(Map<String, Object> paramMap) throws Exception {
		return mainDAO.mainNoticeList(paramMap);
	}

	@Override
	public Integer mainNoticeListTotalCount(Map<String, Object> paramMap) throws Exception {
		return mainDAO.mainNoticeListTotalCount(paramMap);
	}
	
	@Override
	public void mainNoticeInsert(Map<String, Object> paramMap) throws Exception {
		mainDAO.mainNoticeInsert(paramMap);
	}

}
