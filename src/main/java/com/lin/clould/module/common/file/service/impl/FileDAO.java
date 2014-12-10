package com.lin.clould.module.common.file.service.impl;

import java.util.List;
import java.util.Map;

import com.lin.clould.common.framework.common.database.ibatis.CommonDao;

public class FileDAO extends CommonDao {
	
	public List<?> mainNoticeList(Map<String, Object> paramMap) throws Exception {
		return list("BoardSQL001.mainNoticeList", paramMap);
	}

	public Integer mainNoticeListTotalCount(Map<String, Object> paramMap) throws Exception {
		return (Integer) selectByPk("BoardSQL001.mainNoticeListTotalCount",paramMap);
	}

}
