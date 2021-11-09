package com.demo.app.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.app.model.Content;
import com.demo.app.repository.ContentRepository;
import com.demo.app.service.ContentPageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServiceTest {
	
	@Autowired
	private ContentPageService contentPageService;
	
	@MockBean
	private ContentRepository contentRepository;
	
	@Test
	public void searchContentByIdTest(){
		System.out.println();
		int id = 5;
		Content content = new Content();
		content.setCreated_date(new Date());
		content.setId(5);
		content.setCreator("creator");
		content.setTitle("title");
		content.setJournal("Action");
		content.setSummary("Summary");
		content.setPublished(true);
//		Content resultContent = new Content();
		Mockito.when(contentRepository.findById(5)).thenReturn(content);
		Content resultContent=contentPageService.searchContentById(5);
//		System.out.println(resultContent.toString());
//		assertEquals(id, resultContent.getContentid());
		assertEquals(5, resultContent.getContentid());
		
	}
	
	@Test
	public void searchContentByIdNullTest(){
		Mockito.when(contentRepository.findById(555)).thenReturn(null);
		Content content = contentPageService.searchContentById(555);
		assertNull(content);
				
		
	}

	
	

}
