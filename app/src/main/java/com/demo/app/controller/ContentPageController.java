package com.demo.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Content;
import com.demo.app.model.ContentRequest;
import com.demo.app.repository.ContentRepository;
import com.demo.app.response.ContentResponse;
import com.demo.app.service.ContentPageService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContentPageController {
	
	@Autowired
	private ContentPageService contentPageService;
	
	@Autowired
	private ContentRepository contentRepository;
	
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("backend");
		return "Hello from other side 213123";
	}

	
	@PostMapping("/addContent")
	public int addContent(@RequestBody ContentRequest contentRequest) {
		System.out.println("addContent controller");
		System.out.println(contentRequest.toString());
		return contentPageService.addContent(contentRequest);
	}
	
	@GetMapping("/searchContent/{id}")
	public Content searchContentById(@PathVariable int id,HttpServletResponse response) {
		System.out.println("searchContent controller" + id);
		Cookie cookie = new Cookie("test","testfrom_backend");
		response.addCookie(cookie);
		return contentPageService.searchContentById(id);
	}
	
//	@GetMapping("/searchBundle/{id}")
//	public List<Content> searchBundleById(@PathVariable int id) {
//		
//		Content content = new Content();
//		Content content1 = new Content();
//		Content content2 = new Content();
//		content.setCreator("asd");
//		content.setTitle("asd");
//		content.setJournal("asd");
//		content.setSummary("asd");
//		content.setId(5);
//		
//		content1=content;
//		content2=content;
//		List<Content> contentList = new ArrayList<>();
//		contentList.add(content2);
//		contentList.add(content1);
//
//		contentList.add(content);
//        return contentList;
//		
//		
//		
//	}
}
	