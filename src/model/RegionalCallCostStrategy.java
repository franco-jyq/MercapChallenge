package model;

public class RegionalCallCostStrategy implements CallStrategy {

    @Override
    public float calculateCost(CallData callData) {
        return callData.getDuration() * callData.getRegionRate();
    }

}