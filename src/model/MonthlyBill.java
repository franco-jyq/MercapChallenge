package model;

import java.util.HashMap;

public class MonthlyBill {
    private float basicMonthlyFee;
    HashMap<CallType, Float> callCosts;
    private CallStrategy callStrategy;

    public MonthlyBill(float basicMonthlyFee) {
        this.basicMonthlyFee = basicMonthlyFee;
        this.callCosts = new HashMap<CallType, Float>();
        this.callCosts.put(CallType.LOCAL, (float) (0));
        this.callCosts.put(CallType.INTERNATIONAL, (float) (0));
        this.callCosts.put(CallType.NATIONAL, (float) (0));
    }

    public void setCallStrategy(CallStrategy call) {
        this.callStrategy = call;

    }

    public void addCall(CallData callData) {
        Float cost = callCosts.get(callData.getCallType());
        Float newCost = cost + this.callStrategy.calculateCost(callData);
        callCosts.put(callData.getCallType(), newCost);
    }

    public void generateBill() {

        float localCost = callCosts.get(CallType.LOCAL);
        float nationalCost = callCosts.get(CallType.NATIONAL);
        float internationalCost = callCosts.get(CallType.INTERNATIONAL);
        float totalCost = basicMonthlyFee + localCost + nationalCost + internationalCost;

        System.out.println("-----------------Monthly Bill-------------------");
        System.out.printf("Monthly fee: %.2f\n", basicMonthlyFee);
        System.out.printf("Local calls cost: %.2f\n", localCost);
        System.out.printf("National calls cost: %.2f\n", nationalCost);
        System.out.printf("International calls cost: %.2f\n", internationalCost);
        System.out.printf("Total cost: %.2f\n", totalCost);
        System.out.println("------------------------------------------------");
    }
}