package model;

public interface CallStrategy {
    float calculateCost(int duration);

    CallType getCallType();
}
