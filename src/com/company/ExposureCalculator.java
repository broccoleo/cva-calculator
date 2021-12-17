package com.company;

import java.util.HashMap;

public class ExposureCalculator {

    static double getExpectedExposure(int yearsToMaturity, double parValue, double couponRate, double riskFreeRate) {
        double expectedExposureToDefaultLoss = (1 + couponRate) * parValue;
        double presentValueFactor = Math.pow(1 + riskFreeRate, yearsToMaturity);
        return expectedExposureToDefaultLoss / presentValueFactor;
    }

    static double getLossGivenDefault(double expectedExposure, double recoveryRate) {
        return expectedExposure - (expectedExposure * recoveryRate);
    }

    static double getPresentValueFactor(int year, double riskFreeRate) {
        return 1 / Math.pow(1 + riskFreeRate, year);
    }

    static double getPresentValueOfExpectedLoss(double presentValueFactor, double lossGivenDefault, double previousYearsProbabilityOfDefault, double hazardRate) {
        double probabilityOfDefault = previousYearsProbabilityOfDefault * hazardRate;
        return presentValueFactor * lossGivenDefault * probabilityOfDefault;
    }

    static HashMap<Integer, Double> getProbabilitiesOfSurvival(double hazardRate, int yearsToMaturity) {
        HashMap<Integer, Double> probabilitiesOfSurvival = new HashMap<>();
        probabilitiesOfSurvival.put(0, 1.0);
        for (int i = 1; i < yearsToMaturity + 1; i++) {
            probabilitiesOfSurvival.put(i, Math.pow(1 - hazardRate, i));
        }
        return probabilitiesOfSurvival;
    }
}
