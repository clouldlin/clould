package com.lin.clould.module.main.service.impl;

import java.util.List;
import java.util.Map;

import com.lin.clould.common.framework.common.database.ibatis.CommonDao;

public class MainDAO extends CommonDao {
	
	public List<?> mainNoticeList(Map<String, Object> paramMap) throws Exception {
		return list("BoardSQL001.mainNoticeList", paramMap);
	}

	public Integer mainNoticeListTotalCount(Map<String, Object> paramMap) throws Exception {
		return (Integer) selectByPk("BoardSQL001.mainNoticeListTotalCount",paramMap);
	}

	public void mainNoticeInsert(Map<String, Object> paramMap) throws Exception {
		insert("BoardSQL001.mainNoticeInsert", paramMap);
	}
	
	public Map mainNoticeView(String seq) throws Exception {
		return (Map)selectByPk("BoardSQL001.mainNoticeView", seq);
	}
	

}
