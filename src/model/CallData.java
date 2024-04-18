package model;

import java.util.HashMap;

public class CallData {
    CallType callType;
    int duration;
    String location;
    HashMap<String, Float> Rates;
    Float rate;

    public CallData(CallType callType, int duration, Float rate) {
        this.callType = callType;
        this.duration = duration;
        this.rate = rate;
    }

    public CallData(CallType callType, int duration, String location, HashMap<String, Float> Rates) {
        this.callType = callType;
        this.duration = duration;
        this.location = location;
        this.Rates = Rates;
    }

    public float getDuration() {
        return duration;
    }

    public float getRegionRate() {
        return Rates.get(location);
    }

    public float getRate() {
        return rate;
    }

    public CallType getCallType() {
        return callType;
    }
}
