package com.demo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.model.Bundle;

@Repository
public interface BundleRepository extends CrudRepository<Bundle, Integer> {

}
