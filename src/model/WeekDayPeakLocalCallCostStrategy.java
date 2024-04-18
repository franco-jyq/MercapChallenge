package model;
//public final float WEEKDAY_PEAK_LOCAL_CALL_COST = (float) 0.2;

public class WeekDayPeakLocalCallCostStrategy implements CallStrategy {

    @Override
    public float calculateCost(CallData callData) {
        return (float) (callData.getDuration() * 0.2);
    }

}