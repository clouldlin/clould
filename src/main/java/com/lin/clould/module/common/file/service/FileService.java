package com.lin.clould.module.common.file.service;

import java.util.List;
import java.util.Map;

public interface FileService {

	List<?> mainNoticeList(Map<String, Object> paramMap) throws Exception;

	Integer mainNoticeListTotalCount(Map<String, Object> paramMap) throws Exception;

}
