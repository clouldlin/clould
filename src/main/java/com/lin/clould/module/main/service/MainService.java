package com.lin.clould.module.main.service;

import java.util.List;
import java.util.Map;

public interface MainService {

	List<?> mainNoticeList(Map<String, Object> paramMap) throws Exception;

	Integer mainNoticeListTotalCount(Map<String, Object> paramMap) throws Exception;

}
