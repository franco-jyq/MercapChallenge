package model;

import java.util.HashMap;

public class InternationalCallCostStrategy implements LongDistanceCall {
    @Override
    public float calculateCost(int duration, String country, HashMap<String, Float> countryRates) {
        return duration * countryRates.get(country);
    }
}
