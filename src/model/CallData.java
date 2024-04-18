package model;

import java.util.HashMap;

public class CallData {
    CallType callType;
    int duration;
    String location;
    HashMap<String, Float> Rates;

    public CallData(CallType callType, int duration) {
        this.callType = callType;
        this.duration = duration;
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

    public float getRate() {
        return Rates.get(location);
    }

    public CallType getCallType() {
        return callType;
    }
}
