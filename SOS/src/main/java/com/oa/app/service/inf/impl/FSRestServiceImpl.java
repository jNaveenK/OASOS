package com.oa.app.service.inf.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oa.app.domain.RequestValues;
import com.oa.app.entity.AnalyticsTable;
import com.oa.app.entity.Employee;
import com.oa.app.repo.*;
import com.oa.app.service.inf.FSRestService;


@Service("fsRestService")
public class FSRestServiceImpl implements FSRestService {

	private final static Logger LOGGER = Logger.getLogger(FSRestServiceImpl.class.getName());

	@Autowired
	@Qualifier("employeeRepo")
	EmployeeRepo employeeRepo;
	@Autowired
	@Qualifier("AnalyticsRepo")
	AnalyticsRepo analyticsRepo;

	@Override
	public List<String> correlationCheck(RequestValues greetingNew) {
		
		
		/*List<Employee> findemployee(String name)
		{
			return (List<String>) employeeRepo.findByName(name);
			
		}*/
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
	public AnalyticsTable calculateOverAllScore(RequestValues requestValues) {
		
		
		Integer overAllScore=0;
		Integer clientValuePotentialScore=0;
		Integer dealValuePotentialScore=0;
		Integer downSelectComplianceScore=0;
		Integer competeCapabilityScore=0;
		
		clientValuePotentialScore=(requestValues.getClientInvolvementValueDiscovery()+requestValues.getConfdenceInCloseDate()+requestValues.getBusinessValue()+requestValues.getValueMeasurability());
		dealValuePotentialScore=(requestValues.getClientLocation()+requestValues.getCloseDateV()+requestValues.getFunding()+requestValues.getClientAbilityImplementation()+requestValues.getRiskAssesment()
		+requestValues.getProfitabilityToYou()+requestValues.getFutureValueToYou());
		downSelectComplianceScore=(requestValues.getBuyingCriteriaCompliance()+requestValues.getCBuyingCriteriaCompliance()	+requestValues.getClientHistory()
		+requestValues.getCClientHistory()+requestValues.getCulturalFit()+requestValues.getCCulturalFit());
		competeCapabilityScore=(requestValues.getUnderstandingDecisionMaking()
				+requestValues.getCUnderstandingDecisionMaking()+requestValues.getPoliticalClientSupport()+requestValues.getCPoliticalClientSupport()+requestValues.getExecutiveSponsorship()
				+requestValues.getCExecutiveSponsorship()+requestValues.getSalesCampaignMomentum()+requestValues.getCSalesCampaignMomentum());
		
		
		
		overAllScore=(requestValues.getClientInvolvementValueDiscovery()+requestValues.getConfdenceInCloseDate()+requestValues.getBusinessValue()+requestValues.getValueMeasurability()
		+requestValues.getClientLocation()+requestValues.getCloseDateV()+requestValues.getFunding()+requestValues.getClientAbilityImplementation()+requestValues.getRiskAssesment()
		+requestValues.getProfitabilityToYou()+requestValues.getFutureValueToYou()+requestValues.getBuyingCriteriaCompliance()+requestValues.getCBuyingCriteriaCompliance()
		+requestValues.getClientHistory()+requestValues.getCClientHistory()+requestValues.getCulturalFit()+requestValues.getCCulturalFit()+requestValues.getUnderstandingDecisionMaking()
		+requestValues.getCUnderstandingDecisionMaking()+requestValues.getPoliticalClientSupport()+requestValues.getCPoliticalClientSupport()+requestValues.getExecutiveSponsorship()
		+requestValues.getCExecutiveSponsorship()+requestValues.getSalesCampaignMomentum()+requestValues.getCSalesCampaignMomentum());
		System.out.println("overAllScore"+overAllScore);
		
		
		findemployee("Naveen");
		AnalyticsTable at= new AnalyticsTable();
		
		System.out.println("requestValues.getOpportunityId()"+requestValues.getOpportunityId());
		at.setOAID(1002);
		at.setOpportunityId(requestValues.getOpportunityId());
		System.out.println("requestValues.getOpportunityId()"+at.getOpportunityId());
		at.setOrganisationName(requestValues.getOrganisationName());
		at.setCompetitorId(requestValues.getCompetitorId());
		at.setStartDate(requestValues.getStartDate());
		at.setCloseDate(requestValues.getCloseDate());
		at.setDownSelectDate(requestValues.getDownSelectDate());
		at.setOARunBy(requestValues.getOARunBy());
		at.setOARunDate(requestValues.getOARunDate());
		at.setClientInvolvementValueDiscovery(requestValues.getClientInvolvementValueDiscovery());
		at.setConfdenceInCloseDate(requestValues.getConfdenceInCloseDate());
		at.setBusinessValue(requestValues.getBusinessValue());
		at.setValueMeasurability(requestValues.getValueMeasurability());
		at.setClientLocation(requestValues.getClientLocation());
		at.setCloseDateV(requestValues.getCloseDateV());
		at.setFunding(requestValues.getFunding());
		at.setClientAbilityImplementation(requestValues.getClientAbilityImplementation());
		at.setRiskAssesment(requestValues.getRiskAssesment());
		at.setProfitabilityToYou(requestValues.getProfitabilityToYou());
		at.setFutureValueToYou(requestValues.getFutureValueToYou());
		at.setBuyingCriteriaCompliance(requestValues.getBuyingCriteriaCompliance());
		at.setCBuyingCriteriaCompliance(requestValues.getCBuyingCriteriaCompliance());
		at.setClientHistory(requestValues.getClientHistory());
		at.setCClientHistory(requestValues.getCClientHistory());
		at.setCulturalFit(requestValues.getCulturalFit());
		at.setCCulturalFit(requestValues.getCCulturalFit());
		at.setUnderstandingDecisionMaking(requestValues.getUnderstandingDecisionMaking());
		at.setCUnderstandingDecisionMaking(requestValues.getCUnderstandingDecisionMaking());
		at.setPoliticalClientSupport(requestValues.getPoliticalClientSupport());
		at.setCPoliticalClientSupport(requestValues.getCPoliticalClientSupport());
		at.setExecutiveSponsorship(requestValues.getExecutiveSponsorship());
		at.setCExecutiveSponsorship(requestValues.getCExecutiveSponsorship());		
		at.setSalesCampaignMomentum(requestValues.getSalesCampaignMomentum());
		at.setCSalesCampaignMomentum(requestValues.getCSalesCampaignMomentum());
		System.out.println("overAllScore"+overAllScore);
		at.setOverAllOAScore(overAllScore);
		at.setClientValuePotentialScore(clientValuePotentialScore);
		at.setDealValuePotentialScore(dealValuePotentialScore);
		at.setDownSelectComplianceScore(downSelectComplianceScore);
		at.setCompeteCapabilityScore(competeCapabilityScore);
		
		return at;
	}



	@Override
	public Employee findemployee(String name) {
		Employee c = employeeRepo.findByName("Naveen");
		System.out.println("emplyuee"+c);
		return c;
	//	return null;
	}



}