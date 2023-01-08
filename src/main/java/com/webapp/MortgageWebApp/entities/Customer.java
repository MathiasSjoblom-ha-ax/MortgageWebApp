package com.webapp.MortgageWebApp.entities;

import java.text.DecimalFormat;

public class Customer {

    String name;
    double totalLoan;
    double interest;
    int years;

    public Customer(String name, double totalLoan, double interest, int years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getMonthlyPayment() {

        //Mortgage calculator utan math.h
        DecimalFormat df = new DecimalFormat("#.##");
        double principal = totalLoan;
        double annualInterest = interest;
        double monthlyInterest = (annualInterest / 12) / 100;
        int numberOfPayments = years * 12;

        double result = 1 + monthlyInterest;
        for (int i = 0; i < numberOfPayments; i++) {
            result = result * (1 + monthlyInterest);
        }

        double monthlyPayment = (principal * result * monthlyInterest) / (result-1);
        return df.format(monthlyPayment);
    }

}