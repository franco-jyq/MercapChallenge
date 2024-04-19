package model;

public class WeeklyCallCostStrategy implements ICallStrategy {

    @Override
    public double calculateCost(Call callData) {
        return (double) (callData.getDuration() * callData.getRate());
    }

}
