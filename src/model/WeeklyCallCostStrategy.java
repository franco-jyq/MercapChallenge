package model;

public class WeeklyCallCostStrategy implements CallStrategy {

    @Override
    public double calculateCost(Call callData) {
        return (double) (callData.getDuration() * callData.getRate());
    }

}
