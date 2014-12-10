package com.lin.clould.module.login.service.impl;

import com.lin.clould.common.framework.common.database.ibatis.CommonDao;

public class LoginDao extends CommonDao {

	private LoginDao() {
		
	}

	private static LoginDao dao;
	private LoginVO loginVO;

	public static LoginDao getInstance() {
		if (dao == null) {
			dao = new LoginDao();
		}
		return dao;
	}

	public LoginVO selectUserById(String id) throws Exception {
		
		loginVO = new LoginVO();
		
		loginVO.setId("heo");
		loginVO.setPw("heo");
		
		return loginVO;
	}

}