package com.demo.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.app.model.Content;
import com.demo.app.repository.ContentRepository;
import com.demo.app.service.ContentPageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(controllers=ContentPageController.class)
public class ContentControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContentPageService contentPageService;
	
	@Test
	public void searchContentByIdTest() throws Exception {
		Content content = new Content();
		content.setCreated_date(new Date());
		content.setId(5);
		content.setCreator("creator");
		content.setTitle("title");
		content.setJournal("Action");
		content.setSummary("Summary");
		content.setPublished(true);
		Mockito.when(contentPageService.searchContentById(Mockito.anyInt())).thenReturn(content);
		
		String url="/searchContentById/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(content);
		String outputJson = result.getResponse().getContentAsString();
		int a=1;
		assertEquals(expectedJson, outputJson);
		
//		 Content content = new Content();
//		 Content contentResult = new Content();
//		 content.setCreated_date(new Date(24-10-2021));
//		 content.setCreator("Frank");
//		 content.setTitle("Ribery");
//		 content.setId(132);
//		 content.setPublished(false);
//		 content.setJournal("Thriller");
//		 content.setSummary("Curve");
//		 
////		 assertThat((T) this.testRestTemplate.getForObject("http://localhost:"+port+"/searchcontent/132", Content.class), content);
//		
//	contentResult=testRestTemplate.getForObject("http://localhost:"+port+
//				"/searchcontent/132", Content.class);
//	
//	 assertEquals(content, contentResult);
		
		
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
		
	}
}
