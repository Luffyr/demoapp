package com.demo.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BUNDLE")
public class Bundle {
	
	
	@Id
	@Column(name="bundleid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bundleid_generator")
	@SequenceGenerator(name="bundleid_generator",initialValue=1,allocationSize=1,sequenceName="bundleid_seq")
	private int bundleid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="creator")
	private String creator;
	
	@Column(name="published")
	private Boolean published;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date created_date;
	
	@OneToMany(mappedBy="bundleid",fetch = FetchType.LAZY)
	private List<Junction> junctions;
	
	public int getBundleid() {
		return bundleid;
	}

	public void setBundleid(int bundleid) {
		this.bundleid = bundleid;
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

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	

	public List<Junction> getJunctions() {
		return junctions;
	}

	public void setJunctions(List<Junction> junctions) {
		this.junctions = junctions;
	}

	@Override
	public String toString() {
		return "Bundle [bundleid=" + bundleid + ", title=" + title + ", creator=" + creator + ", published=" + published
				+ ", created_date=" + created_date + ", junctions=" + junctions + "]";
	}
	

}
