package com.trainschedule.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainScheduleResponse {
	public boolean status;
	public String  message;
	public long timestamp;
	
	@JsonProperty("data")
	public TrainSchedule trainSchedule;
}
