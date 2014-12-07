package com.lin.clould.module.main.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.clould.common.framework.common.annotation.Controller;
import com.lin.clould.common.framework.common.annotation.RequestMapping;
import com.lin.clould.common.framework.common.util.string.StringUtil;
import com.lin.clould.common.framework.common.view.View;
import com.lin.clould.module.main.service.MainService;
import com.lin.clould.module.main.service.impl.MainServiceImpl;

@Controller("main")
public class MainController {
	
	MainService mainService = new MainServiceImpl();
	
	@RequestMapping("main")
	public View main(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("firstIndex", StringUtil.isEmpty(request.getParameter("pageIndex"))? 0 : (Integer.parseInt(request.getParameter("pageIndex")) - 1) * 10 + 1);
		paramMap.put("lastIndex", StringUtil.isEmpty(request.getParameter("pageIndex"))? 10 : Integer.parseInt(request.getParameter("pageIndex")) * 10);
		
		int noticeTotalCount = mainService.mainNoticeListTotalCount(paramMap);
		List<?> noticeList = mainService.mainNoticeList(paramMap);
		
		request.setAttribute("module", "main");
		request.setAttribute("noticeTotalCount", noticeTotalCount);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("noticePage", request.getParameter("pageIndex"));
		
		return new View("main/main");
	}
}
