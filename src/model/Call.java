package model;

import java.util.HashMap;

public class Call {
    CallType callType;
    ICallStrategy callStrategy;
    double duration;

    public Call(CallType callType, ICallStrategy callStrategy, double duration) {
        this.callType = callType;
        this.callStrategy = callStrategy;
        this.duration = duration;
    }

    public double getCost() {
        return this.callStrategy.calculateCost(this.duration);
    }

    public CallType getCallType() {
        return callType;
    }

}
