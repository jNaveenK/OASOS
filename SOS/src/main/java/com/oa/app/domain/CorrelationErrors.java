package com.oa.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CorrelationErrors {
	
	   

	public CorrelationErrors(List<String> correlationError, Integer overAllScore, String actionItem) {
		this.correlationError=correlationError;
		this.overAllScore=overAllScore;
		this.actionItem=actionItem;
		// TODO Auto-generated constructor stub
	}

	 
	


	List<String>  correlationError=new ArrayList<String>();
	 Integer overAllScore=0;
	 String actionItem= null;

	public List<String> getCorrelationError() {
		return correlationError;
	}

	public void setCorrelationError(List<String> correlationError) {
		this.correlationError = correlationError;
	}
   
	 public Integer getOverAllScore() {
			return overAllScore;
		}

		public void setOverAllScore(Integer overAllScore) {
			this.overAllScore = overAllScore;
		}

		public String getActionItem() {
			return actionItem;
		}

		public void setActionItem(String actionItem) {
			this.actionItem = actionItem;
		}
	
}