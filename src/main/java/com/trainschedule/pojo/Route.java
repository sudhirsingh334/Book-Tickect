package com.trainschedule.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {
    @JsonProperty("d_day") 
	public int dDay;
    
    @JsonProperty("day") 
    public int day;
    
    @JsonProperty("distance_from_source") 
    public String distanceFromSource;
    
    public String lat;
    
    public String lng;
    
    @JsonProperty("platform_number") 
    public int platformNumber;
    
    @JsonProperty("sta_min") 
    public int staMin;
    
    @JsonProperty("state_code") 
    public String stateCode;
    
    @JsonProperty("state_name") 
    public String stateName;
    
    @JsonProperty("station_code") 
    public String stationCode;
    
    @JsonProperty("station_name") 
    public String stationName;
    
    @JsonProperty("std_min") 
    public int stdMin;
    
    public boolean stop;
    
    @JsonProperty("train_src") 
    public String trainSource;
    
    public int sta;
    
    @JsonProperty("today_sta") 
    public int todaySta;   
}
