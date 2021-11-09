package com.demo.app.model;

import java.util.List;

public class BundleRequest {

    private String title;
	
	private String creator;
	
	private Boolean published;
	
	private List<Integer> contentList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public List<Integer> getContentList() {
		return contentList;
	}

	public void setContentid(List<Integer> contentList) {
		this.contentList = contentList;
	}

	@Override
	public String toString() {
		return "BundleRequest [title=" + title + ", creator=" + creator + ", published=" + published + ", contentid="
				+ contentList + "]";
	}
	
}
