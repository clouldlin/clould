package com.lin.clould.common.framework.common.view;

public class FileDownLoadView implements View {
	
	private String nextPage;
	private boolean redirect;

	public FileDownLoadView() {
	}


	public String getNextPage() {
		return nextPage;
	}

	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public boolean isFile() {
		return true;
	}
}
