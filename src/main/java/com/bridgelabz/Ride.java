package com.bridgelabz;

public class Ride {

    //constant variables
    public double distance;
    public int time;;
    public final CabRide cabRide;

    //Creating Constructor
    public Ride(CabRide ride, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide=ride;
    }

    public int getTime() {

        return time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}