package com.lin.clould.common.framework.common.view;

public class RequestView implements View {
	
	private String nextPage;
	private boolean redirect;

	public RequestView(String nextPage) {
		this(nextPage, false);
	}

	public RequestView(String nextPage, boolean redirect) {
		this.nextPage = nextPage;
		this.redirect = redirect;
	}

	public String getNextPage() {
		return nextPage;
	}

	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public boolean isFile() {
		return false;
	}
}
