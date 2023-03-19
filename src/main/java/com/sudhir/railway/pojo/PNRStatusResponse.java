package com.sudhir.railway.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PNRStatusResponse {
	 public boolean status;
	 public String message;
	 public long timestamp;
	 @JsonProperty("data")
	 public PNRDetails pnrDetails;
}
