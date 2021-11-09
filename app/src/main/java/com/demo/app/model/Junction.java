package com.demo.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Junction")

public class Junction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name="id_generator",initialValue=1,allocationSize=1,sequenceName="id_seq")
	@Column(name="id")
	private int id;

	@Column(name="contentid")
	private int contentid;

	@Column(name="bundleid")
	private int bundleid;
	
	@Override
	public String toString() {
		return "Junction [id=" + id + ", contentid=" + contentid + ", bundleid=" + bundleid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public int getBundleid() {
		return bundleid;
	}

	public void setBundleid(int bundleid) {
		this.bundleid = bundleid;
	}

	
}
