package model;

public class LocalCallCostStrategy implements ICallStrategy {

    @Override
    public double calculateCost(Call callData) {
        return (double) (callData.getDuration() * callData.getLocalRate());
    }

}
