package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
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
    public void  WhenGivenMultipleRidesShouldReturnInVoiceSummary() {
        //Creating object for InvoiceGenerator class
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        //Creating rides object for Rides class taking Multiple rides
        Ride[] rides = {  new Ride(CabRide.NORMAL,2.0, 5),
                new Ride(CabRide.NORMAL,0.1, 1)
        };
        //calling calculateFare method here
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(invoiceSummary, expectedInvoiceSummary);
    }

    @Test
    public void WhenGivenUserIDShouldGetTheListOfRidesFromRepoReturnInVoice() {
        String userId="Bhavani";
        //Creating object for InvoiceGenerator class
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = { new Ride(CabRide.NORMAL,2.0, 5),
                new Ride(CabRide.NORMAL,0.1, 1)};
        generator.addRides(userId,rides);
        InvoiceSummary invoiceSummary=generator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(invoiceSummary, expectedInvoiceSummary);
    }

    @Test
    public void  givenPremiumAndNormalRideForUserIdShouldReturnInvoiceSummary() {
      String userId = "user1";
      InvoiceGenerator generator = new InvoiceGenerator();
      RideRepository  rideRepository = new RideRepository();
      generator.setRideRepository(rideRepository);
      Ride[] rides = new Ride[]{
              new Ride(CabRide.NORMAL, 2.0, 5),
              new Ride(CabRide.PREMIUM, 0.1, 1)};
      generator.addRides(userId, rides);
      InvoiceSummary invoiceSummary = generator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2,45.0);
      Assert.assertEquals(invoiceSummary, expectedInvoice);
    }

}
