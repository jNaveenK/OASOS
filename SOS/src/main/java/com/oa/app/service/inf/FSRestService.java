package com.oa.app.service.inf;

import java.util.List;

import com.oa.app.domain.RequestValues;


public interface FSRestService {
	
	public List<String> correlationCheck(RequestValues greetingNew);

	public Integer calculateOverAllScore(RequestValues requestValues);

	
}
