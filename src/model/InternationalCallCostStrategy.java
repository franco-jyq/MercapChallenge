package model;

import java.util.HashMap;

public class InternationalCallCostStrategy implements LongDistanceCall {

    public CallType callType = CallType.INTERNATIONAL;

    @Override
    public float calculateCost(int duration, String country, HashMap<String, Float> countryRates) {
        return duration * countryRates.get(country);
    }
}
