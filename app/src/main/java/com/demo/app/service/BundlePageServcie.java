package com.demo.app.service;

import com.demo.app.model.Bundle;
import com.demo.app.model.BundleRequest;
import com.demo.app.response.BundleResponse;

public interface BundlePageServcie {

	public Bundle addBundle(BundleRequest bundleRequest);

	public BundleResponse getBundle(int id);

}
