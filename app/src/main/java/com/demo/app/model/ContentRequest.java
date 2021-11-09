package com.demo.app.model;

import javax.persistence.Column;

public class ContentRequest {

	private String title;
	
	private String creator;

	private String journal;
	
	private String summary;
	
	private Boolean published;
	
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

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "ContentRequest [title=" + title + ", creator=" + creator + ", journal=" + journal + ", summary="
				+ summary + ", published=" + published + "]";
	}
}
