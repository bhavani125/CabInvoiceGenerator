package com.bridgelabz;

public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KILOMETER =10 ;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE =5 ;
    RideRepository rideRepository=new RideRepository();

    //Main method
    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }
    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
    //Creating calculateFare method
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }
    //Creating calculateFare method
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            //calling calculateFare method here
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    //Creating calculateFare method
    public InvoiceSummary getTotalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            //calling calculateFare method here
            totalFare += ride.cabRide.calculateCostOfRide(ride);
        }
      return new InvoiceSummary(rides.length, totalFare);
    }
    //Creating addRides method
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.getTotalFare(rideRepository.getRide(userId));
    }
}
