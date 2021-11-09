package com.demo.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.model.Content;
import com.demo.app.model.ContentRequest;
import com.demo.app.repository.ContentRepository;
import com.demo.app.response.ContentResponse;
import com.demo.app.response.ContentResponse;

@Service
public class ContentPageServiceImpl implements ContentPageService {
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Override
	public int addContent(ContentRequest contentRequest) {
		System.out.println("addContent controller");
		Content content = new Content();
		content.setCreator(contentRequest.getCreator());
		content.setTitle(contentRequest.getTitle());
		content.setJournal(contentRequest.getJournal());
		content.setSummary(contentRequest.getSummary());
		content.setPublished(contentRequest.getPublished());
        content.setCreated_date(new Date());
		
		content = contentRepository.save(content);
		System.out.println("id   "+content.getContentid());
		return content.getContentid();	
	}
	
	@Override
	public Content searchContentById(int id) {
		System.out.println("func "+id);

		Content content=contentRepository.findById(id);
		if(content==null) {
			System.out.println("null is checked");
		}
		return content;
	}

}
