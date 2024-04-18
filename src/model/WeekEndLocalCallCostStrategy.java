package model;

public class WeekEndLocalCallCostStrategy implements CallStrategy {

    @Override
    public float calculateCost(CallData callData) {
        return (float) (callData.getDuration() * 0.1);
    }

}
