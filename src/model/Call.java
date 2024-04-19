package model;

import java.util.HashMap;

public class Call {
    CallType callType;
    ICallStrategy callStrategy;
    int duration;
    String location;
    HashMap<String, Double> rates;
    double rate;

    public Call(CallType callType, ICallStrategy callStrategy, int duration, double rate) {
        this.callType = callType;
        this.callStrategy = callStrategy;
        this.duration = duration;
        this.rate = rate;
    }

    public Call(CallType callType, ICallStrategy callStrategy, int duration, String location,
            HashMap<String, Double> rates) {
        this.callType = callType;
        this.callStrategy = callStrategy;
        this.duration = duration;
        this.location = location;
        this.rates = rates;
    }

    public double getCost() {
        return this.callStrategy.calculateCost(this);
    }

    public double getDuration() {
        return duration;
    }

    public double getRegionRate() {
        return rates.get(location);
    }

    public double getRate() {
        return rate;
    }

    public CallType getCallType() {
        return callType;
    }

}
