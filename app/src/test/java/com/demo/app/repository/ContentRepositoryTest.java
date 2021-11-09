package com.demo.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.app.model.Content;


@DataJpaTest
public class ContentRepositoryTest {
	
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Test
	public void findByIdTest(){
		
		Content content = new Content();
		content = contentRepository.findById(132);
		assertEquals(132, content.getContentid());

	}
}
