package com.sudhir.railway.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PNRDetails {
    @JsonProperty("Pnr") 
    public String pnr;
    @JsonProperty("TrainNo") 
    public String trainNo;
    @JsonProperty("TrainName") 
    public String trainName;
    @JsonProperty("Doj") 
    public String doj;
    @JsonProperty("BookingDate") 
    public String bookingDate;
    @JsonProperty("Quota") 
    public String quota;
    @JsonProperty("DestinationDoj") 
    public String destinationDoj;
    @JsonProperty("SourceDoj") 
    public String sourceDoj;
    @JsonProperty("From") 
    public String from;
    @JsonProperty("To") 
    public String to;
    @JsonProperty("ReservationUpto") 
    public String reservationUpto;
    @JsonProperty("BoardingPoint") 
    public String boardingPoint;
    @JsonProperty("Class") 
    public String bookedClass;
    @JsonProperty("ChartPrepared") 
    public boolean chartPrepared;
    @JsonProperty("BoardingStationName") 
    public String boardingStationName;
    @JsonProperty("TrainStatus") 
    public String trainStatus;
    @JsonProperty("TrainCancelledFlag") 
    public boolean trainCancelledFlag;
    @JsonProperty("ReservationUptoName") 
    public String reservationUptoName;
    @JsonProperty("PassengerCount") 
    public int passengerCount;
    @JsonProperty("PassengerStatus") 
    public ArrayList<PassengerStatus> passengerList;
    @JsonProperty("DepartureTime") 
    public String departureTime;
    @JsonProperty("ArrivalTime") 
    public String arrivalTime;
    @JsonProperty("ExpectedPlatformNo") 
    public String expectedPlatformNo;
    @JsonProperty("BookingFare") 
    public String bookingFare;
    @JsonProperty("TicketFare") 
    public String ticketFare;
    @JsonProperty("CoachPosition") 
    public String coachPosition;
    @JsonProperty("Rating") 
    public double rating;
    @JsonProperty("FoodRating") 
    public double foodRating;
    @JsonProperty("PunctualityRating") 
    public double punctualityRating;
    @JsonProperty("CleanlinessRating") 
    public double cleanlinessRating;
    @JsonProperty("SourceName") 
    public String sourceName;
    @JsonProperty("DestinationName") 
    public String destinationName;
    @JsonProperty("Duration") 
    public String duration;
    @JsonProperty("RatingCount") 
    public int ratingCount;
    @JsonProperty("HasPantry") 
    public boolean hasPantry;
    @JsonProperty("FromDetails") 
    public FromDetails fromDetails;
    @JsonProperty("ToDetails") 
    public ToDetails toDetails;
    @JsonProperty("BoardingPointDetails") 
    public BoardingPointDetails boardingPointDetails;
    @JsonProperty("ReservationUptoDetails") 
    public ReservationUptoDetails reservationUptoDetails;
}
