package com.sudhir.railway.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerStatus{
    @JsonProperty("Pnr") 
    public Object pnr;
    @JsonProperty("Number") 
    public int number;
    @JsonProperty("Prediction") 
    public Object prediction;
    @JsonProperty("PredictionPercentage") 
    public String predictionPercentage;
    @JsonProperty("ConfirmTktStatus") 
    public String confirmTktStatus;
    @JsonProperty("Coach") 
    public String coach;
    @JsonProperty("Berth") 
    public int berth;
    @JsonProperty("BookingStatus") 
    public String bookingStatus;
    @JsonProperty("CurrentStatus") 
    public String currentStatus;
    @JsonProperty("CoachPosition") 
    public Object coachPosition;
    @JsonProperty("BookingBerthNo") 
    public String bookingBerthNo;
    @JsonProperty("BookingCoachId") 
    public String bookingCoachId;
    @JsonProperty("BookingStatusNew") 
    public String bookingStatusNew;
    @JsonProperty("BookingStatusIndex") 
    public String bookingStatusIndex;
    @JsonProperty("CurrentBerthNo") 
    public String currentBerthNo;
    @JsonProperty("CurrentCoachId") 
    public String currentCoachId;
    @JsonProperty("BookingBerthCode") 
    public String bookingBerthCode;
    @JsonProperty("CurrentBerthCode") 
    public Object currentBerthCode;
    @JsonProperty("CurrentStatusNew") 
    public String currentStatusNew;
    @JsonProperty("CurrentStatusIndex") 
    public String currentStatusIndex;
}
