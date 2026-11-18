package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // A list of the parent type can hold any child object
        List<Asset> assets = new ArrayList<>();


        // Create house objects
        // Money amounts are BigDecimal objects built from a String, so the
        // amount is stored exactly as it is written
        House house1 = new House("My House", "2021-01-01", new BigDecimal("200000.00"), "123 Main St", 1, 2000, 5000);
        House house2 = new House("Vacation Home", "2022-05-01", new BigDecimal("300000.00"), "456 Beach Rd", 2, 1500, 10000);

        // Create vehicle objects
        Vehicle vehicle1 = new Vehicle("My Car", "2021-01-01", new BigDecimal("25000.00"), "Toyota Camry", 2021, 50000);
        Vehicle vehicle2 = new Vehicle("Tom's Truck", "2018-06-01", new BigDecimal("35000.00"), "Ford F-150", 2019, 80000);
        // Over 100,000 miles and not a Honda or a Toyota: loses the extra 25%
        Vehicle vehicle3 = new Vehicle("Work Van", "2018-03-15", new BigDecimal("28000.00"), "Ford Transit", 2018, 130000);
        // Over 10 years old: worth a flat 1000.00
        Vehicle vehicle4 = new Vehicle("Old Car", "2012-09-10", new BigDecimal("18000.00"), "Honda Civic", 2010, 150000);
        // Over 10 years old AND over 100,000 miles, not a Honda or a Toyota:
        // the flat 1000.00 also loses the extra 25%
        Vehicle vehicle5 = new Vehicle("Old Truck", "2011-04-20", new BigDecimal("22000.00"), "Chevrolet Silverado", 2009, 180000);

        // Add assets to the list
        assets.add(house1);
        assets.add(house2);
        assets.add(vehicle1);
        assets.add(vehicle2);
        assets.add(vehicle3);
        assets.add(vehicle4);
        assets.add(vehicle5);

        // Display asset information
        for (Asset asset : assets) {
            // These getters are defined in Asset, so they work for every item
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            // %.2f prints the amount with two decimal places, %n ends the line
            System.out.printf("Original Cost: $%.2f%n", asset.getOriginalCost());

            // The variable "asset" is of type Asset, so only Asset's methods
            // can be called on it. getAddress() or getYear() would not compile.
            // instanceof asks "is this object really a House?". If it is,
            // the downcast (House) gives us a House variable for the same
            // object, and the House methods become available
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Year: " + vehicle.getYear());
            }

            // No instanceof needed here: getValue() exists in Asset, and Java
            // runs the House or the Vehicle version on its own
            System.out.printf("Value: $%.2f%n", asset.getValue());
            System.out.println();
        }
    }
}