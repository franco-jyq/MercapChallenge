package model;

import java.util.HashMap;

public class MonthlyBill {
    private float basicMonthlyFee;
    private float localCost;
    private float nationalCost;
    private float internationalCost;
    private LocalCall localCallStrategy;
    private LongDistanceCall nationalCallStrategy;
    private LongDistanceCall internationalCallStrategy;

    public MonthlyBill(float basicMonthlyFee) {
        this.basicMonthlyFee = basicMonthlyFee;
    }

    public void setLocalCallStrategy(LocalCall call) {
        this.localCallStrategy = call;
    }

    public void setNationalCallStrategy(LongDistanceCall call) {
        this.nationalCallStrategy = call;
    }

    public void setInternationalCallStrategy(LongDistanceCall call) {
        this.internationalCallStrategy = call;
    }

    public void addLocalCall(int duration) {
        localCost += localCallStrategy.calculateCost(duration);
    }

    public void addNationalCall(int duration, String state, HashMap<String, Float> stateRates) {
        nationalCost += nationalCallStrategy.calculateCost(duration, state, stateRates);
    }

    public void addInternationalCall(int duration, String country, HashMap<String, Float> countryRates) {
        internationalCost += internationalCallStrategy.calculateCost(duration, country, countryRates);
    }

    public void generateBill() {
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