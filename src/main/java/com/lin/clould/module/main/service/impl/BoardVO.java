package com.lin.clould.module.main.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	
	private String board_date_format = "yyyy-MM-dd";
	private int row;
	private int seq;
	private String title;
	private String content;
	private Date reg_date;

	private String board_date_format() {
		String regDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(board_date_format);
			regDate = format.format(reg_date);
		} catch (NullPointerException e) {
			regDate = "";
		}
		return regDate;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		String regDate = board_date_format();
		return regDate;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}
