package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double riskFreeRate = 0.03;
        Scanner bondScanner = new Scanner(System.in);
        System.out.println("Welcome to CVA calculator. Please input the characteristics of your bond:");
        System.out.println("Years to maturity: ");
        int yearsToMaturity = bondScanner.nextInt();
        System.out.println("Par value: ");
        int parValue = bondScanner.nextInt();
        System.out.println("Coupon rate (in percent): ");
        double couponRate = bondScanner.nextDouble()/100;
        System.out.println("Recovery rate (in percent): ");
        double recoveryRate = bondScanner.nextDouble()/100;
        System.out.println("Hazard rate (in percent): ");
        double hazardRate = bondScanner.nextDouble()/100;

        RiskyBond bond = new RiskyBond(yearsToMaturity, parValue, couponRate, recoveryRate, hazardRate, new HashMap<>());

        System.out.println("Calculating CVA for bond with " + bond.yearsToMaturity() + " years to maturity," +
                " par value of " + bond.parValue() + ", coupon rate of " + bond.couponRateInPercent()*100 + "%, " +
                "recovery rate of " + bond.recoveryRate()*100 + "% and hazard rate of " + bond.hazardRate()*100 + "%. \n" +
                "The risk-free rate is " + riskFreeRate*100 + "%.");
        double cva = CvaCalculator.calculateCva(bond, riskFreeRate);

        System.out.println("Credit valuation adjustment of your bond is " + cva);
    }
}
