package model;

import java.util.HashMap;

public class Call {
    CallType callType;
    ICallStrategy callStrategy;
    int duration;
    String location;
    HashMap<String, Double> regionalRates;
    double localRate;

    public Call(CallType callType, ICallStrategy callStrategy, int duration, double localRate) {
        this.callType = callType;
        this.callStrategy = callStrategy;
        this.duration = duration;
        this.localRate = localRate;
    }

    public Call(CallType callType, ICallStrategy callStrategy, int duration, String location,
            HashMap<String, Double> regionalRates) {
        this.callType = callType;
        this.callStrategy = callStrategy;
        this.duration = duration;
        this.location = location;
        this.regionalRates = regionalRates;
    }

    public double getCost() {
        return this.callStrategy.calculateCost(this);
    }

    public double getDuration() {
        return duration;
    }

    public double getRegionRate() {
        return regionalRates.get(location);
    }

    public double getLocalRate() {
        return localRate;
    }

    public CallType getCallType() {
        return callType;
    }

}
