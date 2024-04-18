package model;
//public final float WEEKDAY_PEAK_LOCAL_CALL_COST = (float) 0.2;

public class WeekDayPeakLocalCallCostStrategy implements LocalCall {
    @Override
    public float calculateCost(int duration) {
        return (float) (duration * 0.2);
    }
}