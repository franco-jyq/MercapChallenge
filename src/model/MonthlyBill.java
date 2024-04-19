package model;

import java.util.HashMap;

public class MonthlyBill {
    private double basicMonthlyFee;
    HashMap<CallType, Double> callCosts;
    String date;

    public MonthlyBill(double basicMonthlyFee, String date) {
        this.date = date;
        this.basicMonthlyFee = basicMonthlyFee;
        this.callCosts = new HashMap<CallType, Double>();
        this.callCosts.put(CallType.LOCAL, (double) (0));
        this.callCosts.put(CallType.INTERNATIONAL, (double) (0));
        this.callCosts.put(CallType.NATIONAL, (double) (0));
    }

    public void addCall(Call call) {
        double cost = callCosts.get(call.getCallType());
        double newCost = cost + call.getCost();
        callCosts.put(call.getCallType(), newCost);
    }

    public void generateBill() {

        double localCost = callCosts.get(CallType.LOCAL);
        double nationalCost = callCosts.get(CallType.NATIONAL);
        double internationalCost = callCosts.get(CallType.INTERNATIONAL);
        double totalCost = basicMonthlyFee + localCost + nationalCost + internationalCost;

        System.out.println("-----------------Monthly Bill-------------------");
        System.out.printf("Date: %s\n", date);
        System.out.printf("Monthly fee: %.2f\n", basicMonthlyFee);
        System.out.printf("Local calls cost: %.2f\n", localCost);
        System.out.printf("National calls cost: %.2f\n", nationalCost);
        System.out.printf("International calls cost: %.2f\n", internationalCost);
        System.out.printf("Total cost: %.2f\n", totalCost);
        System.out.println("------------------------------------------------");
    }
}