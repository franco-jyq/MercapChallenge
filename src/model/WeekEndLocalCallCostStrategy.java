package model;

public class WeekEndLocalCallCostStrategy implements CallStrategy {

    public CallType callType = CallType.LOCAL;

    @Override
    public float calculateCost(int duration) {
        return (float) (duration * 0.1);
    }

    @Override
    public CallType getCallType() {
        return callType;
    }
}
