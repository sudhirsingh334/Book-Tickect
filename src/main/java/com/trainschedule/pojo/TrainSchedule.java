package com.trainschedule.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

//data class	
public class TrainSchedule {
    @JsonProperty("class") 
	public ArrayList<TrainClass> classList;
	
    @JsonProperty("quota")
    public ArrayList<Quota> quotaList;
    
    @JsonProperty("route")
	public ArrayList<Route> routeList;

	

}
