package com.oa.app.service.inf.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oa.app.domain.RequestValues;
import com.oa.app.service.inf.FSRestService;


@Service("fsRestService")
public class FSRestServiceImpl implements FSRestService {

	private final static Logger LOGGER = Logger.getLogger(FSRestServiceImpl.class.getName());



	@Override
	public List<String> correlationCheck(RequestValues greetingNew) {
		
		 List<String>  correlationError=new ArrayList<String>();
		
		//Condition A (BV & PCS)
		
		if((greetingNew.getBusinessValue()==3) && (greetingNew.getPoliticalClientSupport()==-3))
		{
			correlationError.add("A-Upper Left Negative Correlation");
		}
		//Condition B ( PCS& UDMP)
		if((greetingNew.getPoliticalClientSupport()==4) && (greetingNew.getUnderstandingDecisionMaking()==-3))
		{
			correlationError.add("B-Upper Left Negative Correlation");
		}
		else if((greetingNew.getPoliticalClientSupport()==-3) && (greetingNew.getUnderstandingDecisionMaking()==4))
		{
			correlationError.add("B-Lower Right Negative Correlation");
		}
		//Condition C ( PCS& ES)
		if((greetingNew.getPoliticalClientSupport()==4) && (greetingNew.getExecutiveSponsorship()==-3))
		{
			correlationError.add("C-Upper Left Negative Correlation");
		}
		else if((greetingNew.getPoliticalClientSupport()==-3) && (greetingNew.getExecutiveSponsorship()==4))
		{
			correlationError.add("C-Lower Right Negative Correlation");
		}
		
		//Condition d (ES& SCM)
		if((greetingNew.getExecutiveSponsorship()==4) && (greetingNew.getSalesCampaignMomentum()==-3))
		{
				correlationError.add("D-Upper Left Negative Correlation");
		}
		else if((greetingNew.getExecutiveSponsorship()==-3) && (greetingNew.getSalesCampaignMomentum()==4))
		{
				correlationError.add("D-Lower Right Negative Correlation");
		}
		//Condition E (PCS & CIVD)
		
		if((greetingNew.getPoliticalClientSupport()==0 ||greetingNew.getPoliticalClientSupport()==4) && (greetingNew.getClientInvolvementValueDiscovery()==-3||greetingNew.getClientInvolvementValueDiscovery()==0))
		{
				correlationError.add("E- Negative Correlation");
		}
		return correlationError;

	}
	


	@Override
	public Integer calculateOverAllScore(RequestValues requestValues) {
		
		Integer overAllScore=0;
		overAllScore=(requestValues.getClientInvolvementValueDiscovery()+requestValues.getConfdenceInCloseDate()+requestValues.getBusinessValue()+requestValues.getValueMeasurability()
		+requestValues.getClientLocation()+requestValues.getCloseDateV()+requestValues.getFunding()+requestValues.getClientAbilityImplementation()+requestValues.getRiskAssesment()
		+requestValues.getProfitabilityToYou()+requestValues.getFutureValueToYou()+requestValues.getBuyingCriteriaCompliance()+requestValues.getCBuyingCriteriaCompliance()
		+requestValues.getClientHistory()+requestValues.getCClientHistory()+requestValues.getCulturalFit()+requestValues.getCCulturalFit()+requestValues.getUnderstandingDecisionMaking()
		+requestValues.getCUnderstandingDecisionMaking()+requestValues.getPoliticalClientSupport()+requestValues.getCPoliticalClientSupport()+requestValues.getExecutiveSponsorship()
		+requestValues.getCExecutiveSponsorship()+requestValues.getSalesCampaignMomentum()+requestValues.getCSalesCampaignMomentum());
		System.out.println("overAllScore"+overAllScore);
		
		return overAllScore;
	}



}