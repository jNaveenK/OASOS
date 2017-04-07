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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oa.app.domain.RequestValues;
import com.oa.app.service.inf.FSRestServiceYCalc;


@Service("fsRestServiceYCalc")
public class FSRestServiceYCalcImpl implements FSRestServiceYCalc {

	private final static Logger LOGGER = Logger.getLogger(FSRestServiceYCalcImpl.class.getName());

	@Override
	public String yCalculation(RequestValues requestValues) throws ParseException {
		// Initialization of 15,16 & 17 values
		int decisionMakingA1=0;
		int decisionMakingA2=requestValues.getUnderstandingDecisionMaking();
		int decisionMakingB1=4;
		int decisionMakingB2=requestValues.getCUnderstandingDecisionMaking();
		
		int politicalSupportA1=0;
		int politicalSupportA2=requestValues.getPoliticalClientSupport();
		int politicalSupportB1=4;
		int politicalSupportB2=requestValues.getCPoliticalClientSupport();
		
		int executiveSponsorshipA1=0;
		int executiveSponsorshipA2=requestValues.getExecutiveSponsorship();
		int executiveSponsorshipB1=4;
		int executiveSponsorshipB2=requestValues.getCExecutiveSponsorship();
		long nexus;
		String possbilityActionItem = null;
	
		// Initialization of start date , close date, previous and current date values
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");	
		Date startDate = requestValues.getStartDate();
		Date closeDate = requestValues.getCloseDate();
		Date previousDate=format.parse("25/03/2017");
		Date currentDate = requestValues.getOARunDate();
		
		//Calculation of X , days between start date and close date	
		long differ= closeDate.getTime()-startDate.getTime();
		int X =(int) (differ/86400000);
		System.out.println("Close date "+X);
		
		
		//Calculation for t2- t1, days between current date and previous  date
		long differT2= currentDate.getTime()-previousDate.getTime();
		long differT2T1 = (differT2/86400000);
		System.out.println("differT2T1 **"+differT2T1);
		
		//Calculation for t1- t0, days between previous date and start  date
		long differT1= previousDate.getTime()-startDate.getTime();
		long differT1T0 = (differT1/86400000);
		System.out.println("differT2T1 **"+differT1T0);
		
		//Calculation for CA1,CA2,CB1,CB2
		int sumCA1=(decisionMakingA1+politicalSupportA1+executiveSponsorshipA1);
		int sumCA2=(decisionMakingA2+politicalSupportA2+executiveSponsorshipA2);
		int sumCB1=(decisionMakingB1+politicalSupportB1+executiveSponsorshipB1);
		int sumCB2=(decisionMakingB2+politicalSupportB2+executiveSponsorshipB2);
		
		//Calculation for momentum m = (cb2-cb1)/t2-t1
			
		long mA=(sumCA2-sumCA1)/differT2T1;
		long mB=(sumCB2-sumCB1)/differT2T1;
		
		System.out.println("Momentum"+mA);
		System.out.println("Momentum"+mB);
		
		//Calculation for b 
		long bA=-((mA*(differT1T0)-(sumCA1)));
		long bB=-((mB*(differT1T0)-(sumCB1)));
		
		System.out.println("b value for A "+bA);
		System.out.println("b value for B "+bB);
		
		//Calculation for Y= mx+b
		
		Long yA= (mA*X)+bA;
		Long yB= (mB*X)+bB;
		
		System.out.println("yA  value" +yA);
		System.out.println("yB  value" +yB);
		nexus=nexusCalculation(mA,mB,bA,bB);
		System.out.println("Nexus"+nexus);
		
		 if(nexus==0 && yA>yB){	
				System.out.println("possiblity 7**yA Value"+yA+"***yB value"+yB);
				possbilityActionItem="possiblity 7";
		}
		 else if(nexus==0 && yA<yB){
				System.out.println("possiblity 8**yA Value"+yA+"***yB value"+yB);
				possbilityActionItem="possiblity 8";			
		}
		 else if((X==nexus||X<nexus+7||X>nexus-7)&& (mA>mB) ){
				System.out.println("possiblity 3**mA Value"+mA+"***mB value"+mB+"Nexus value"+nexus+"***x Value"+X);
				possbilityActionItem="possiblity 3";
		}
    	 else if((X==nexus||X<nexus+7||X>nexus-7)&& (mA<mB) ){
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
		
		
		return possbilityActionItem;	
		}

	 private long nexusCalculation(long mA, long mB, long bA, long bB) {
		
		long nexus=0;
		long differ=(mA-mB);
		if(differ!=0){
 nexus=((bB-bA)/differ);
		}
		System.out.println("nexus"+ nexus);
	return nexus;
}}