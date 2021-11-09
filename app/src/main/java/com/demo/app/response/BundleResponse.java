package com.demo.app.response;

import java.util.List;

import com.demo.app.model.Bundle;
import com.demo.app.model.Content;

public class BundleResponse {
	
    private Bundle bundle;
	private List<Content> contentList;
	public Bundle getBundle() {
		return bundle;
	}
	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}
	public List<Content> getContentList() {
		return contentList;
	}
	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}
	@Override
	public String toString() {
		return "BundleResponse [bundle=" + bundle + ", contentList=" + contentList + "]";
	}

}
