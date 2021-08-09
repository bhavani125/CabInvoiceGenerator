package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        //Creating object for InvoiceGenerator class
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void WhenGivenLessDistanceAndTimeShouldReturnMiniFare() {
        //Creating object for InvoiceGenerator class
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare,0.0);
    }

    @Test
    public void whenGivenMultipleRidesShouldReturnTotalFare() {
        //Creating object for InvoiceGenerator class
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        //Creating rides object for Rides class
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        //calling calculateTotalFare method
        double totalFare = invoiceGenerator.calculateTotalFare(rides);
        System.out.println("Total Fare = "+totalFare);
        Assert.assertEquals(30, totalFare,0.0);
    }

    @Test
    public void WhenGivenMultipleRidesShouldReturnSizeAndAverageFare() {
        //Creating object for InvoiceGenerator class
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        //Creating rides object for Rides class taking Multiple rides
        Ride[] rides = { new Ride(20.0,4),
                new Ride(45.0,1),
                new Ride(75.0,1),
                new Ride(45.5,1)};
        //calling calculateTotalFare method
        double totalFare = invoiceGenerator.calculateTotalFare(rides);
        int numberOfRides = invoiceGenerator.getNumberOfRides(rides);
        double averageTotalFare = invoiceGenerator.calculateAverageFarePerRide(rides);
        //printing the totalFare,numberOfRides,averageTotalFare
        System.out.println("Total Fare = " +totalFare);
        System.out.println("Number of ride = " +numberOfRides);
        System.out.println("Average Total Fare " +averageTotalFare);

        Assert.assertEquals(1862,totalFare,0.0);
        Assert.assertEquals(4,numberOfRides);
        Assert.assertEquals(465,averageTotalFare,0.5);
    }
}
