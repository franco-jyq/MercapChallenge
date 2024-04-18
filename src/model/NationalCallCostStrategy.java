package model;

import java.util.HashMap;

public class NationalCallCostStrategy implements LongDistanceCall {
    @Override
    public float calculateCost(int duration, String state, HashMap<String, Float> stateRates) {
        return duration * stateRates.get(state);
    }
}