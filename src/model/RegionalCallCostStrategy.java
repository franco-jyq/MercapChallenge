package model;

public class RegionalCallCostStrategy implements ICallStrategy {

    @Override
    public double calculateCost(Call call) {
        return call.getDuration() * call.getRegionRate();
    }

}