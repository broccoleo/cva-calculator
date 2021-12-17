package com.company;

import java.util.HashMap;

public record RiskyBond(int yearsToMaturity, int parValue, double couponRateInPercent, double recoveryRate,
                        double hazardRate, HashMap<Integer,Double> lossesGivenDefault) {
}
