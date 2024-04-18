package model;

public class WeeklyCallCostStrategy implements CallStrategy {

    @Override
    public float calculateCost(CallData callData) {
        return (float) (callData.getDuration() * callData.getRate());
    }

}
