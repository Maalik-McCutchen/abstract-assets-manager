package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {

        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public int getValue() {

        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;

        BigDecimal value = getOriginalCost();


        if (age <= 3) {
            for (int i = 0; i < age; i++) {
                value = value.multiply(new BigDecimal("0.97"));
            }
        } else if (age <= 6) { // 4-5-6
            for (int i = 0; i < age; i++) {
                value = value.multiply(new BigDecimal("0.94"));
            }
        } else if (age <= 10) { // 7-8-9-10
            for (int i = 0; i < age; i++) {
                value = value.multiply(new BigDecimal("0.92"));
            }
        } else {

            value = new BigDecimal("1000.00");
        }

        String makeModelLower = makeModel.toLowerCase();
        if (!(makeModelLower.contains("honda") || makeModelLower.contains("toyota"))
                && odometer > 100000) {
            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }
}