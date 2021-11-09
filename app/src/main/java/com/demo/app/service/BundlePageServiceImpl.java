package com.demo.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.model.Bundle;
import com.demo.app.model.BundleRequest;
import com.demo.app.model.Content;
import com.demo.app.model.Junction;
import com.demo.app.repository.BundleRepository;
import com.demo.app.repository.ContentRepository;
import com.demo.app.repository.JunctionRepository;
import com.demo.app.response.BundleResponse;

@Service
public class BundlePageServiceImpl implements BundlePageServcie {
	
	@Autowired
	private BundleRepository bundleRepository;
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private JunctionRepository junctionRepository;

	@Override
	public Bundle addBundle(BundleRequest bundleRequest) {
		Bundle bundle = new Bundle();
		bundle.setCreator(bundleRequest.getCreator());
		bundle.setTitle(bundleRequest.getTitle());
		bundle.setPublished(bundleRequest.getPublished());

		bundle.setCreated_date(new Date());
		try {
		bundle=bundleRepository.save(bundle);
		}catch(Exception e) {
			System.out.println("Failedd");
			return null;
		}
	    System.out.println("generated "+ bundle.getBundleid() );
	    System.out.println(bundle.toString());
	   
	    for(int i=0;i<bundleRequest.getContentList().size();i++) {
	    	Junction junction = new Junction();
	    	 junction.setBundleid(bundle.getBundleid());
		    System.out.println("lop "+ junction.getBundleid() );
	    	junction.setContentid(bundleRequest.getContentList().get(i));
		    System.out.println("lop "+ junction.toString() );
	    	junction=junctionRepository.save(junction);
	    }

		return bundle;
	}
	
	
	@Override
	public BundleResponse getBundle(int id){
		
		Bundle resultBundle = new Bundle();
		BundleResponse bundleResponse = new BundleResponse();

		resultBundle=bundleRepository.findById(id).orElse(null);
		if(resultBundle==null) {
			bundleResponse=null;
			return bundleResponse;
		}
		System.out.println(resultBundle.toString());
		List<Junction> junctions = resultBundle.getJunctions();
		System.out.println(junctions.size());
		Content content = new Content();	
		List<Content> contents = new ArrayList<>();
		for(int i =0;i<junctions.size();i++) {
			content = contentRepository.findById(junctions.get(i).getContentid());
			if(content.getPublished()==true) {
			contents.add(content);}
		}
		contents.forEach(i->{
			System.out.println(i.toString());

		});
		Bundle bundle = new Bundle();
		bundle.setBundleid(resultBundle.getBundleid());
		bundle.setCreator(resultBundle.getCreator());
		bundle.setTitle(resultBundle.getTitle());
		bundle.setPublished(resultBundle.getPublished());
		bundle.setCreated_date(resultBundle.getCreated_date());
		bundleResponse.setContentList(contents);
		bundleResponse.setBundle(bundle);
		System.out.println(bundleResponse.toString());
		return bundleResponse;
	}

}
