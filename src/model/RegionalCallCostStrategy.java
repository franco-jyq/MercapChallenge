package model;

import java.util.HashMap;

public class RegionalCallCostStrategy implements ICallStrategy {

    HashMap<String, Double> regionalRates;
    String location;

    public RegionalCallCostStrategy(HashMap<String, Double> regionalRates, String location) {
        this.regionalRates = regionalRates;
        this.location = location;
    }

    @Override
    public double calculateCost(double duration) {
        return duration * this.regionalRates.get(this.location);
    }

}