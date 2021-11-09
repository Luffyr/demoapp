package com.demo.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CONTENT")
public class Content {
	
	@Id
	@Column(name="contentid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contentid_generator")
	@SequenceGenerator(name="contentid_generator",initialValue=1,allocationSize=1,sequenceName="contentid_seq")
	private int contentid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="creator")
	private String creator;
	
	@Column(name="journal")
	private String journal;
	

	@Column(name="summary")
	private String summary;
	
	@Column(name="published")
	private Boolean published;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date created_date;
	
	
	public int getContentid() {
		return contentid;
	}

	public void setId(int contentid) {
		this.contentid = contentid;
	}

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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
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
		return "Content [contentid=" + contentid + ", title=" + title + ", creator=" + creator + ", journal=" + journal
				+ ", summary=" + summary + ", published=" + published + ", created_date=" + created_date + "]";
	}

	

	
	

}
