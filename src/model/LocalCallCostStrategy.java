package model;

public class LocalCallCostStrategy implements ICallStrategy {

    double localRate;

    public LocalCallCostStrategy(double localRate) {
        this.localRate = localRate;
    }

    @Override
    public double calculateCost(double duration) {
        return duration * this.localRate;
    }

}
