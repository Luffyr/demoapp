package com.demo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.model.Bundle;
import com.demo.app.model.Junction;

@Repository
public interface JunctionRepository extends CrudRepository<Junction, Integer>  {

}
