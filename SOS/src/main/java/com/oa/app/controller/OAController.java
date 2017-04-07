package com.oa.app.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oa.app.domain.CorrelationErrors;
import com.oa.app.domain.RequestValues;
import com.oa.app.service.inf.FSRestService;
import com.oa.app.service.inf.FSRestServiceYCalc;


@RestController
@RequestMapping("/sosAnalysis")
public class OAController {

	@Autowired
	@Qualifier("fsRestService")
	private FSRestService fsService;
	
	@Autowired
	@Qualifier("fsRestServiceYCalc")
	private FSRestServiceYCalc fsRestServiceYCalc;
	
	
	 List<String>  correlationError=new ArrayList<String>();

     @RequestMapping(value ="/api/{opID}/{Org}/{comID}/{SDate}/{CDate}/{DDate}/{OARunBy}/{OADate}/{CIVD}/{CICD}/{BV}/{VM}/{CL}/{CD}/{Funding}/{CAI}/{RA}/{PTY}/{FVTY}/{BCC}/{CBCC}/{CH}/{CCH}/{CF}/{CCF}/{UDM}/{CUDM}/{PCS}/{CPCS}/{ES}/{CES}/{SCM}/{CSCM}", method = RequestMethod.POST, produces = "application/json")
     public  ResponseEntity<CorrelationErrors> testing(@PathVariable(value="opID") Integer opID,
    		 @PathVariable(value="Org") String Org,@PathVariable(value="comID") Integer comID,
    		 @PathVariable(value="SDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date SDate, @PathVariable(value="CDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date CDate,
    		 @PathVariable(value="DDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date DDate, @PathVariable(value="OARunBy") String OARunBy,
    		 @PathVariable(value="OADate") @DateTimeFormat(pattern="yyyy-MM-dd") Date OADate, 
    		 @PathVariable(value="CIVD") Integer CIVD,@PathVariable(value="CICD") Integer CICD,@PathVariable(value="BV") Integer BV,
    		 @PathVariable(value="VM") Integer VM,@PathVariable(value="CL") Integer CL,@PathVariable(value="CD") Integer CD,
    		 @PathVariable(value="Funding") Integer Funding,@PathVariable(value="CAI") Integer CAI,@PathVariable(value="RA") Integer RA,
    		 @PathVariable(value="PTY") Integer PTY,@PathVariable(value="FVTY") Integer FVTY,@PathVariable(value="BCC") Integer BCC,
    		 @PathVariable(value="CBCC") Integer CBCC,@PathVariable(value="CH") Integer CH,@PathVariable(value="CCH") Integer CCH,
    		 @PathVariable(value="CF") Integer CF,@PathVariable(value="CCF") Integer CCF,@PathVariable(value="UDM") Integer UDM,
    		 @PathVariable(value="CUDM") Integer CUDM,@PathVariable(value="PCS") Integer PCS,@PathVariable(value="CPCS") Integer CPCS,
    		 @PathVariable(value="ES") Integer ES,@PathVariable(value="CES") Integer CES,@PathVariable(value="SCM") Integer SCM,
    		 @PathVariable(value="CSCM") Integer CSCM) throws ParseException {	 
    	 RequestValues requestValues= new RequestValues(opID,Org,comID, SDate,CDate,DDate,OARunBy,OADate,CIVD,CICD,BV,VM,CL,CD,Funding,CAI,RA,PTY,FVTY,BCC,CBCC,CH,CCH,CF,CCF,UDM,CUDM,PCS,CPCS,ES,CES,SCM,CSCM);
    	 Integer overAllScore=0;
    	 String actionItem= null;
    	 
    	 correlationError= fsService.correlationCheck(requestValues);
    	 if(correlationError.size()==0 ){
    		 System.out.println("size"+correlationError.size());
    	 overAllScore= fsService.calculateOverAllScore(requestValues);
    	 actionItem=fsRestServiceYCalc.yCalculation(requestValues);
    	 }
    	 CorrelationErrors ce= new CorrelationErrors(correlationError,overAllScore,actionItem);
         return new ResponseEntity<CorrelationErrors>(ce , HttpStatus.OK);
     }
     

}