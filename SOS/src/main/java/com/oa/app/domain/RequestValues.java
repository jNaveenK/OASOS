package com.oa.app.domain;

import java.util.Date;

public class RequestValues {
    private  Integer OpportunityId;
    private  String OrganisationName;
    private  Integer CompetitorId;
    private Date StartDate;
    private Date CloseDate;
    private Date DownSelectDate;
    private  String OARunBy;
    private Date OARunDate;
    private  Integer ClientInvolvementValueDiscovery;
    private  Integer ConfdenceInCloseDate;
    private  Integer BusinessValue;
    private  Integer ValueMeasurability;
    private  Integer ClientLocation;
    private  Integer CloseDateV;
    private  Integer Funding;
    private  Integer ClientAbilityImplementation;
    private  Integer RiskAssesment;
    private  Integer ProfitabilityToYou;
    private  Integer FutureValueToYou;
    private  Integer BuyingCriteriaCompliance;
    private  Integer CBuyingCriteriaCompliance;
    private  Integer ClientHistory;
    private  Integer CClientHistory;
    private  Integer CulturalFit;
    private  Integer CCulturalFit;
    private  Integer UnderstandingDecisionMaking;
    private  Integer CUnderstandingDecisionMaking;
    private  Integer PoliticalClientSupport;
    private  Integer CPoliticalClientSupport;
    private  Integer ExecutiveSponsorship;
    private  Integer CExecutiveSponsorship;
    private  Integer SalesCampaignMomentum;
    private  Integer CSalesCampaignMomentum;
    public RequestValues(Integer opID, String org, Integer comID, Date sDate, Date cDate, Date dDate, String oARunBy,
			Date oADate, Integer cIVD, Integer cICD, Integer bV, Integer vM, Integer cL, Integer cD, Integer funding,
			Integer cAI, Integer rA, Integer pTY, Integer fVTY, Integer bCC, Integer cBCC, Integer cH, Integer cCH,
			Integer cF, Integer cCF, Integer uDM, Integer cUDM, Integer pCS, Integer cPCS, Integer eS, Integer cES,
			Integer sCM, Integer cSCM) {
    	this.OpportunityId=opID;
    	this.OrganisationName=org;
    	this.CompetitorId=comID;
    	this.StartDate=sDate;
    	this.CloseDate=cDate;
    	this.DownSelectDate=dDate;
    	this.OARunBy=oARunBy;
    	this.OARunDate=oADate;
    	this.ClientInvolvementValueDiscovery=cIVD;
    	this.ConfdenceInCloseDate=cICD;
    	this.BusinessValue=bV;
    	this.ValueMeasurability=vM;
    	this.ClientLocation=cL;
    	this.CloseDateV=cD;
    	this.Funding=funding;
    	this.ClientAbilityImplementation=cAI;
    	this.RiskAssesment=rA;
    	this.ProfitabilityToYou=pTY;
    	this.FutureValueToYou=fVTY;
    	this.BuyingCriteriaCompliance=bCC;
    	this.CBuyingCriteriaCompliance=cBCC;
    	this.ClientHistory=cH;
    	this.CClientHistory=cCH;
    	this.CulturalFit=cF;
    	this.CCulturalFit=cCF;
    	this.UnderstandingDecisionMaking=uDM;
    	this.CUnderstandingDecisionMaking=cUDM;
    	this.PoliticalClientSupport=pCS;
    	this.CPoliticalClientSupport=cPCS;
    	this.ExecutiveSponsorship=eS;
    	this.CExecutiveSponsorship=cES;
    	this.SalesCampaignMomentum=sCM;
    	this.CSalesCampaignMomentum=cSCM;
    	
    	
    	
	}
	
	public Integer getOpportunityId() {
		return OpportunityId;
	}
	public void setOpportunityId(Integer opportunityId) {
		OpportunityId = opportunityId;
	}
	public String getOrganisationName() {
		return OrganisationName;
	}
	public void setOrganisationName(String organisationName) {
		OrganisationName = organisationName;
	}
	public Integer getCompetitorId() {
		return CompetitorId;
	}
	public void setCompetitorId(Integer competitorId) {
		CompetitorId = competitorId;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getCloseDate() {
		return CloseDate;
	}
	public void setCloseDate(Date closeDate) {
		CloseDate = closeDate;
	}
	public Date getDownSelectDate() {
		return DownSelectDate;
	}
	public void setDownSelectDate(Date downSelectDate) {
		DownSelectDate = downSelectDate;
	}
	public String getOARunBy() {
		return OARunBy;
	}
	public void setOARunBy(String oARunBy) {
		OARunBy = oARunBy;
	}
	public Date getOARunDate() {
		return OARunDate;
	}
	public void setOARunDate(Date oARunDate) {
		OARunDate = oARunDate;
	}
	public Integer getClientInvolvementValueDiscovery() {
		return ClientInvolvementValueDiscovery;
	}
	public void setClientInvolvementValueDiscovery(Integer clientInvolvementValueDiscovery) {
		ClientInvolvementValueDiscovery = clientInvolvementValueDiscovery;
	}
	public Integer getConfdenceInCloseDate() {
		return ConfdenceInCloseDate;
	}
	public void setConfdenceInCloseDate(Integer confdenceInCloseDate) {
		ConfdenceInCloseDate = confdenceInCloseDate;
	}
	public Integer getBusinessValue() {
		return BusinessValue;
	}
	public void setBusinessValue(Integer businessValue) {
		BusinessValue = businessValue;
	}
	public Integer getValueMeasurability() {
		return ValueMeasurability;
	}
	public void setValueMeasurability(Integer valueMeasurability) {
		ValueMeasurability = valueMeasurability;
	}
	public Integer getClientLocation() {
		return ClientLocation;
	}
	public void setClientLocation(Integer clientLocation) {
		ClientLocation = clientLocation;
	}
	public Integer getCloseDateV() {
		return CloseDateV;
	}
	public void setCloseDateV(Integer closeDateV) {
		CloseDateV = closeDateV;
	}
	public Integer getFunding() {
		return Funding;
	}
	public void setFunding(Integer funding) {
		Funding = funding;
	}
	public Integer getClientAbilityImplementation() {
		return ClientAbilityImplementation;
	}
	public void setClientAbilityImplementation(Integer clientAbilityImplementation) {
		ClientAbilityImplementation = clientAbilityImplementation;
	}
	public Integer getRiskAssesment() {
		return RiskAssesment;
	}
	public void setRiskAssesment(Integer riskAssesment) {
		RiskAssesment = riskAssesment;
	}
	public Integer getProfitabilityToYou() {
		return ProfitabilityToYou;
	}
	public void setProfitabilityToYou(Integer profitabilityToYou) {
		ProfitabilityToYou = profitabilityToYou;
	}
	public Integer getFutureValueToYou() {
		return FutureValueToYou;
	}
	public void setFutureValueToYou(Integer futureValueToYou) {
		FutureValueToYou = futureValueToYou;
	}
	public Integer getBuyingCriteriaCompliance() {
		return BuyingCriteriaCompliance;
	}
	public void setBuyingCriteriaCompliance(Integer buyingCriteriaCompliance) {
		BuyingCriteriaCompliance = buyingCriteriaCompliance;
	}
	public Integer getCBuyingCriteriaCompliance() {
		return CBuyingCriteriaCompliance;
	}
	public void setCBuyingCriteriaCompliance(Integer cBuyingCriteriaCompliance) {
		CBuyingCriteriaCompliance = cBuyingCriteriaCompliance;
	}
	public Integer getClientHistory() {
		return ClientHistory;
	}
	public void setClientHistory(Integer clientHistory) {
		ClientHistory = clientHistory;
	}
	public Integer getCClientHistory() {
		return CClientHistory;
	}
	public void setCClientHistory(Integer cClientHistory) {
		CClientHistory = cClientHistory;
	}
	public Integer getCulturalFit() {
		return CulturalFit;
	}
	public void setCulturalFit(Integer culturalFit) {
		CulturalFit = culturalFit;
	}
	public Integer getCCulturalFit() {
		return CCulturalFit;
	}
	public void setCCulturalFit(Integer cCulturalFit) {
		CCulturalFit = cCulturalFit;
	}
	public Integer getUnderstandingDecisionMaking() {
		return UnderstandingDecisionMaking;
	}
	public void setUnderstandingDecisionMaking(Integer understandingDecisionMaking) {
		UnderstandingDecisionMaking = understandingDecisionMaking;
	}
	public Integer getCUnderstandingDecisionMaking() {
		return CUnderstandingDecisionMaking;
	}
	public void setCUnderstandingDecisionMaking(Integer cUnderstandingDecisionMaking) {
		CUnderstandingDecisionMaking = cUnderstandingDecisionMaking;
	}
	public Integer getPoliticalClientSupport() {
		return PoliticalClientSupport;
	}
	public void setPoliticalClientSupport(Integer politicalClientSupport) {
		PoliticalClientSupport = politicalClientSupport;
	}
	public Integer getCPoliticalClientSupport() {
		return CPoliticalClientSupport;
	}
	public void setCPoliticalClientSupport(Integer cPoliticalClientSupport) {
		CPoliticalClientSupport = cPoliticalClientSupport;
	}
	public Integer getExecutiveSponsorship() {
		return ExecutiveSponsorship;
	}
	public void setExecutiveSponsorship(Integer executiveSponsorship) {
		ExecutiveSponsorship = executiveSponsorship;
	}
	public Integer getCExecutiveSponsorship() {
		return CExecutiveSponsorship;
	}
	public void setCExecutiveSponsorship(Integer cExecutiveSponsorship) {
		CExecutiveSponsorship = cExecutiveSponsorship;
	}
	public Integer getSalesCampaignMomentum() {
		return SalesCampaignMomentum;
	}
	public void setSalesCampaignMomentum(Integer salesCampaignMomentum) {
		SalesCampaignMomentum = salesCampaignMomentum;
	}
	public Integer getCSalesCampaignMomentum() {
		return CSalesCampaignMomentum;
	}
	public void setCSalesCampaignMomentum(Integer cSalesCampaignMomentum) {
		CSalesCampaignMomentum = cSalesCampaignMomentum;
	}

    
   
	
}