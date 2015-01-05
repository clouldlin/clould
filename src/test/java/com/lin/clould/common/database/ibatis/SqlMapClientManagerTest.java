package com.lin.clould.common.database.ibatis;

import org.junit.Ignore;
import org.junit.Test;

import com.ibatis.sqlmap.client.SqlMapClient;


public class SqlMapClientManagerTest {
	
	private SqlMapClient sqlMap;

	@Ignore
	@Test
	public void nothing(){
		
	}
	
	@Ignore
	@Test
	public void canCreateObject(){
		sqlMap = SqlMapClientManager.getSqlMapClient();
	}
}