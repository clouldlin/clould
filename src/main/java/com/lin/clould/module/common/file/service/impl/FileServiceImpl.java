package com.lin.clould.module.common.file.service.impl;

import java.util.List;
import java.util.Map;

import com.lin.clould.module.common.file.service.FileService;

public class FileServiceImpl implements FileService {

	FileDAO mainDAO = new FileDAO();
	
	@Override
	public List<?> mainNoticeList(Map<String, Object> paramMap) throws Exception {
		return mainDAO.mainNoticeList(paramMap);
	}

	@Override
	public Integer mainNoticeListTotalCount(Map<String, Object> paramMap) throws Exception {
		return mainDAO.mainNoticeListTotalCount(paramMap);
	}

}
