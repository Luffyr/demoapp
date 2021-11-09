package com.demo.app.service;


import com.demo.app.model.Content;
import com.demo.app.model.ContentRequest;


public interface ContentPageService {

	public Content searchContentById(int id);
	
	public int addContent(ContentRequest contentRequest);
	
}
