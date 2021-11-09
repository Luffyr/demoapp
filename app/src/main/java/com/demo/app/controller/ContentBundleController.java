package com.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Bundle;
import com.demo.app.model.BundleRequest;
import com.demo.app.model.Content;
import com.demo.app.model.ContentRequest;
import com.demo.app.response.BundleResponse;
import com.demo.app.service.BundlePageServcie;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ContentBundleController {
	@Autowired
	private BundlePageServcie bundlePageService;
	
	@PostMapping("/addBundle")
	public Bundle addBundle(@RequestBody BundleRequest bundleRequest) {
		System.out.println("addBundle controller");
		System.out.println(bundleRequest.toString());
		return bundlePageService.addBundle(bundleRequest);

	}
	@GetMapping("/searchBundle/{id}")
	public BundleResponse searchBundleById(@PathVariable int id) {
		System.out.println("correct");
		return bundlePageService.getBundle(id);
	}
}
