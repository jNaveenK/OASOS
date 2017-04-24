package com.oa.app.service.inf.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oa.app.domain.RequestValues;
import com.oa.app.entity.AnalyticsTable;
import com.oa.app.repo.AnalyticsRepo;
import com.oa.app.service.inf.FSRestServiceYCalc;


@Service("fsRestServiceYCalc")
public class FSRestServiceYCalcImpl implements FSRestServiceYCalc {

	private final static Logger LOGGER = Logger.getLogger(FSRestServiceYCalcImpl.class.getName());
	@Autowired
	@Qualifier("AnalyticsRepo")
	AnalyticsRepo analyticsRepo;
	@Override
	public String yCalculation(AnalyticsTable requestValues) {
		String possbilityActionItem = null;
		int X=0;
		long differT2T1=0;
		long differT1T0=0;
		double mA=0;
		double mB=0;
		List<AnalyticsTable> at =analyticsRepo.fetchByOpportunityId(requestValues.getOpportunityId());
		System.out.println("at"+at.size());
		if(at.size()==0)
		{
			System.out.println("inside ifat"+at.size());
			requestValues.setOAID(1);
			analyticsRepo.save(requestValues);
		}
		else{
		
		requestValues.setOAID(at.get(0).getOAID()+1);
		
		// Initialization of 15,16 & 17 values
		int decisionMakingA1=at.get(0).getUnderstandingDecisionMaking();
		int decisionMakingA2=requestValues.getUnderstandingDecisionMaking();
		int decisionMakingB1=at.get(0).getCUnderstandingDecisionMaking();
		int decisionMakingB2=requestValues.getCUnderstandingDecisionMaking();
		
		int politicalSupportA1=at.get(0).getPoliticalClientSupport();
		int politicalSupportA2=requestValues.getPoliticalClientSupport();
		int politicalSupportB1=at.get(0).getCPoliticalClientSupport();
		int politicalSupportB2=requestValues.getCPoliticalClientSupport();
		
		int executiveSponsorshipA1=at.get(0).getExecutiveSponsorship();
		int executiveSponsorshipA2=requestValues.getExecutiveSponsorship();
		int executiveSponsorshipB1=at.get(0).getCExecutiveSponsorship();
		int executiveSponsorshipB2=requestValues.getCExecutiveSponsorship();
		double nexus;
		
	
		// Initialization of start date , close date, previous and current date values
		Date startDate = requestValues.getStartDate();
		Date closeDate = requestValues.getCloseDate();
		Date previousDate=at.get(0).getOARunDate();
		Date currentDate = requestValues.getOARunDate();
		
		//Calculation of X , days between start date and close date	
		long differ= closeDate.getTime()-startDate.getTime();
		if(differ!=0)
		 X =(int) (differ/86400000);
		
		
		System.out.println("Close date "+X);
		
		
		//Calculation for t2- t1, days between current date and previous  date
		long differT2= currentDate.getTime()-previousDate.getTime();
		if(differT2!=0)
		differT2T1= (differT2/86400000);
		System.out.println("differT2T1 **"+differT2T1);
		
		//Calculation for t1- t0, days between previous date and start  date
		long differT1= previousDate.getTime()-startDate.getTime();
		if(differT1!=0)
		differT1T0= (differT1/86400000);
		
		System.out.println("differT2T1 **"+differT1T0);
		
		//Calculation for CA1,CA2,CB1,CB2
		double sumCA1=(decisionMakingA1+politicalSupportA1+executiveSponsorshipA1);
		double sumCA2=(decisionMakingA2+politicalSupportA2+executiveSponsorshipA2);
		double sumCB1=(decisionMakingB1+politicalSupportB1+executiveSponsorshipB1);
		double sumCB2=(decisionMakingB2+politicalSupportB2+executiveSponsorshipB2);
		requestValues.setSumYa1(sumCA1);
		requestValues.setSumYa2(sumCA2);
		requestValues.setSumYb1(sumCB1);
		requestValues.setSumYb2(sumCB2);
		//Calculation for momentum m = (cb2-cb1)/t2-t1
		
		if(differT2T1!=0){
			System.out.println(sumCA1);
			System.out.println(sumCA2);
			System.out.println(sumCB1);
			System.out.println(sumCB2);
		mA=(sumCA2-sumCA1)/differT2T1;
		mB=(sumCB2-sumCB1)/differT2T1;}
		requestValues.setMomentumA(mA);
		requestValues.setMomentumB(mB);
		
		System.out.println("Momentum"+mA);
		System.out.println("Momentum"+mB);
		
		//Calculation for b 
		double bA=-((mA*(differT1T0)-(sumCA1)));
		double bB=-((mB*(differT1T0)-(sumCB1)));
		
		requestValues.setInterceptA(bA);
		requestValues.setInterceptB(bB);
		
		System.out.println("b value for A "+bA);
		System.out.println("b value for B "+bB);
		
		//Calculation for Y= mx+b
		
		double yA= (mA*X)+bA;
		double yB= (mB*X)+bB;
		
		requestValues.setyA(yA);
		requestValues.setyB(yB);
		
		System.out.println("yA  value" +yA);
		System.out.println("yB  value" +yB);
		nexus=nexusCalculation(mA,mB,bA,bB);
		requestValues.setxValue(X);
		requestValues.setNexus(nexus);
		System.out.println("Nexus"+nexus);
		
		 if(nexus==0 && yA>yB){	
				System.out.println("possiblity 7**yA Value"+yA+"***yB value"+yB);
				possbilityActionItem="possiblity 7";
		}
		 else if(nexus==0 && yA<yB){
				System.out.println("possiblity 8**yA Value"+yA+"***yB value"+yB);
				possbilityActionItem="possiblity 8";			
		}
		 else if((X>=nexus-7 && X<=nexus+7)&& (mA>mB) ){
				System.out.println("possiblity 3**mA Value"+mA+"***mB value"+mB+"Nexus value"+nexus+"***x Value"+X);
				possbilityActionItem="possiblity 3";
		}
    	 else if((X>=nexus-7 && X<=nexus+7)&& (mA<mB) ){
				System.out.println("possiblity 6**mA Value"+mA+"***mB value"+mB+"Nexus value"+nexus+"***x Value"+X);
				possbilityActionItem="possiblity 6";
		}
		else if(yB>yA && X<nexus){
			System.out.println("possiblity 1**yA Value"+yA+"***yB value"+yB+"Nexus value"+nexus+"***x Value"+X);
			possbilityActionItem="possiblity 1";
		}
		else if(yA>yB && X>nexus){
			System.out.println("possiblity 2**yA Value"+yA+"***yB value"+yB+"Nexus value"+nexus+"***x Value"+X);
			possbilityActionItem="possiblity 2";
		}
		
		else if(yA>yB && X<nexus){
			System.out.println("possiblity 4**yA Value"+yA+"***yB value"+yB+"Nexus value"+nexus+"***x Value"+X);
			possbilityActionItem="possiblity 4";
		}
		else if(yB>yA && X>nexus){
			System.out.println("possiblity 5**yA Value"+yA+"***yB value"+yB+"Nexus value"+nexus+"***x Value"+X);
			possbilityActionItem="possiblity 5";
		}
		 requestValues.setActionItem(possbilityActionItem);
		 analyticsRepo.save(requestValues);
		
	//	return possbilityActionItem;	
		}
		return possbilityActionItem;	}

	 private double nexusCalculation(double mA, double mB, double bA, double bB) {
		
		 double nexus=0;
		 double differ=(mA-mB);
		if(differ!=0){
 nexus=((bB-bA)/differ);
		}
		System.out.println("nexus"+ nexus);
	return nexus;
}}