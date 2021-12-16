package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        double riskFreeRate = 0.03;
        RiskyBond bond1 = new RiskyBond(5, 100, 0, 0.4, 0.0125, new HashMap<>());
        RiskyBond bond2 = new RiskyBond(5, 100, 10, 0.2, 0.025, new HashMap<>());
        RiskyBond bond3 = new RiskyBond(10, 100, 4, 0.6, 0.005, new HashMap<>());


        double cva1 = CvaCalculator.calculateCva(bond1, riskFreeRate);
        double cva2 = CvaCalculator.calculateCva(bond2, riskFreeRate);
        double cva3 = CvaCalculator.calculateCva(bond3, riskFreeRate);

        System.out.println("Credit valuation adjustment of Bond 1 is " + cva1 + " GBP");
        System.out.println("Credit valuation adjustment of Bond 2 is " + cva2 + " GBP");
        System.out.println("Credit valuation adjustment of Bond 3 is " + cva3 + " GBP");
    }
}
