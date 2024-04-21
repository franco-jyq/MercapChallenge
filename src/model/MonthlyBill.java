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

    public String generateBill() {
        double localCost = callCosts.get(CallType.LOCAL);
        double nationalCost = callCosts.get(CallType.NATIONAL);
        double internationalCost = callCosts.get(CallType.INTERNATIONAL);
        double totalCost = basicMonthlyFee + localCost + nationalCost + internationalCost;

        return String.format(
                "-----------------Monthly Bill-------------------\n" +
                        "Date: %s\n" +
                        "Monthly fee: %.2f\n" +
                        "Local calls cost: %.2f\n" +
                        "National calls cost: %.2f\n" +
                        "International calls cost: %.2f\n" +
                        "Total cost: %.2f\n" +
                        "------------------------------------------------\n",
                date, basicMonthlyFee, localCost, nationalCost, internationalCost, totalCost);
    }
}