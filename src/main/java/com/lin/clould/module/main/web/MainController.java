package com.lin.clould.module.main.web;

import java.awt.image.renderable.ParameterBlock;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.clould.common.framework.common.annotation.Controller;
import com.lin.clould.common.framework.common.annotation.RequestMapping;
import com.lin.clould.common.framework.common.annotation.SessionCertification;
import com.lin.clould.common.framework.common.util.string.StringUtil;
import com.lin.clould.common.framework.common.view.RequestView;
import com.lin.clould.common.framework.common.view.View;
import com.lin.clould.module.main.service.MainService;
import com.lin.clould.module.main.service.impl.MainServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		return new RequestView("main/main");
	}
	
	@SessionCertification
	@RequestMapping("mypage")
	public View mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new RequestView("mypage/mypage");
	}
	
	@RequestMapping("noticeInsert")
	public View noticeInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int fileMaxSize = 50*1024*1024; // 50메가
		String filePath = "/home/files/clould";
		
		MultipartRequest multi;
		ArrayList<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();

			multi = new MultipartRequest(request, filePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			Enumeration<?> fileNames = multi.getFileNames();
			
			while(fileNames.hasMoreElements()){
				Map<String, Object> fileMap = new HashMap<String, Object>();
				String formName = (String) fileNames.nextElement();
				
				String fileName = multi.getFilesystemName(formName);
				String fileOrgName = multi.getOriginalFileName(formName);
				
				fileMap.put("FILE_NAME"   , fileName);
				fileMap.put("FILE_ORG_NAME", fileOrgName);
				fileList.add(fileMap);	
			}
		

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("title", multi.getParameter("title"));
			paramMap.put("content", multi.getParameter("content"));
		
			System.out.println(paramMap.toString());
			
			mainService.mainNoticeInsert(paramMap);
		
		
			return new RequestView("/main/main", true);
	}
}
