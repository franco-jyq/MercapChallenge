package model;

public class WeekEndLocalCallCostStrategy implements LocalCall {
    @Override
    public float calculateCost(int duration) {
        return (float) (duration * 0.1);
    }
}
