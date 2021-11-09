package com.demo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.model.Content;

@Repository
public interface ContentRepository extends CrudRepository<Content, Integer> {
	
	Content findById(int id);

}
