package com.oa.app.service.inf;

import java.util.List;

import com.oa.app.domain.RequestValues;
import com.oa.app.entity.AnalyticsTable;
import com.oa.app.entity.Employee;


public interface FSRestService {
	
	public List<String> correlationCheck(RequestValues greetingNew);

	public AnalyticsTable calculateOverAllScore(RequestValues requestValues);
	Employee findemployee(String name);
		
		
	

	
}
