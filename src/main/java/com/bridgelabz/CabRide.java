package com.bridgelabz;

public enum CabRide {

    NORMAL(10.0,1.0,5.0),
    PREMIUM(15.0,2.0,20.0);

    private final double rsPerKilometer;
    private final double rsPerMinute;
    private final double minFarePerRide;
   //Creating constructor
    CabRide(double costPerKilometer, double costPerMinute, double minFarePerRide) {
        this.rsPerKilometer = costPerKilometer;
        this.rsPerMinute = costPerMinute;
        this.minFarePerRide = minFarePerRide;
    }
    //creating calculateCostOfRide method
    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance * rsPerKilometer + ride.time * rsPerMinute;
        return Math.max(rideCost, minFarePerRide);
    }
}
