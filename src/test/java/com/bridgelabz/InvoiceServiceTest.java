package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Hashtable;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() throws Exception  {
        invoiceGenerator = new InvoiceGenerator();
    }

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
    public void  WhenGivenMultipleRides_ShouldReturnInVoiceSummary() {
        //Creating object for InvoiceGenerator class
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        //Creating rides object for Rides class taking Multiple rides
        Ride[] rides = {  new Ride(2.0, 5),
                new Ride(0.1, 1)
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
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        generator.addRides(userId,rides);
        InvoiceSummary invoiceSummary=generator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(invoiceSummary, expectedInvoiceSummary);
    }

}
