package com.company;

import java.util.HashMap;

import static com.company.ExposureCalculator.*;

public class CvaCalculator {

    static double calculateCva(RiskyBond bond, double riskFreeRate) {
        HashMap<Integer, Double> probabilities = getProbabilitiesOfSurvival(bond.hazardRate(), bond.yearsToMaturity());

        for (int i = 1; i < bond.yearsToMaturity() + 1; i++) {
            double expectedExposure = getExpectedExposure(bond.yearsToMaturity() - i, bond.parValue(), bond.couponRateInPercent(), riskFreeRate);
            double presentValueFactor = getPresentValueFactor(i, riskFreeRate);
            bond.lossesGivenDefault().put(i, getPresentValueOfExpectedLoss(presentValueFactor, getLossGivenDefault(expectedExposure, bond.recoveryRate()), probabilities.get(i - 1), bond.hazardRate()));
        }

        return bond.lossesGivenDefault().values().stream().reduce(Double::sum).orElse(0.00);
    }
}


