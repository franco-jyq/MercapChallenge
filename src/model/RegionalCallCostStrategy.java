package model;

public class RegionalCallCostStrategy implements CallStrategy {

    @Override
    public double calculateCost(Call call) {
        return call.getDuration() * call.getRegionRate();
    }

}