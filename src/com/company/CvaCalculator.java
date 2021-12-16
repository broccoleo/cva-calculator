package com.company;

import java.util.HashMap;

public class CvaCalculator {

    public static double calculateCva(RiskyBond bond, double riskFreeRate) {
        HashMap<Integer, Double> probabilities = ExposureCalculator.getProbabilitiesOfSurvival(bond.hazardRate(), bond.yearsToMaturity());

        for (int i = 1; i < bond.yearsToMaturity() + 1; i++) {
            double expectedExposure = ExposureCalculator.getExpectedExposure(bond.yearsToMaturity() - i, bond.parValue(), bond.couponRateInPercent(), riskFreeRate);
            double presentValueFactor = ExposureCalculator.getPresentValueFactor(i, riskFreeRate);
            bond.lossesGivenDefault().put(i, ExposureCalculator.getPresentValueOfExpectedLoss(presentValueFactor, ExposureCalculator.getLossGivenDefault(expectedExposure, bond.recoveryRate()), probabilities.get(i - 1), bond.hazardRate()));
        }

        return bond.lossesGivenDefault().values().stream().reduce(Double::sum).orElse(0.00);
    }
}


