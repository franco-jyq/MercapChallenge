package service;

import java.util.HashMap;
import java.util.Scanner;

import model.MonthlyBill;
import model.WeeklyCallCostStrategy;
import model.RegionalCallCostStrategy;
import model.Call;
import model.CallType;

public class Main {

    public static final double WEEKDAY_PEAK_LOCAL_CALL_COST = (double) 0.2;
    public static final double WEEKDAY_OFF_PEAK_LOCAL_CALL_COST = (double) 0.1;
    public static final double WEEKEND_LOCAL_CALL_COST = (double) 0.1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyBill bill = new MonthlyBill(10, "30/04/24"); // Costo básico mensual
        HashMap<String, Double> stateRates = new HashMap<String, Double>();
        stateRates.put("IOWA", (double) (0.2));

        HashMap<String, Double> countryRates = new HashMap<String, Double>();
        countryRates.put("US", (double) (0.5));

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Select the type of call you want to add: \n");
            System.out.println("1. Local call during peak hours on weekdays");
            System.out.println("2. Local call during off-peak hours on weekdays");
            System.out.println("3. Local call on weekends");
            System.out.println("4. International call");
            System.out.println("5. National call");
            System.out.println("----------------------------------------------");

            int callType = scanner.nextInt();
            scanner.nextLine();

            switch (callType) {
                case 1:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    bill.addCall(new Call(CallType.LOCAL, new WeeklyCallCostStrategy(), duration,
                            WEEKDAY_PEAK_LOCAL_CALL_COST));
                    break;
                case 2:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration1 = scanner.nextInt();
                    scanner.nextLine();
                    bill.addCall(new Call(CallType.LOCAL, new WeeklyCallCostStrategy(), duration1,
                            WEEKDAY_OFF_PEAK_LOCAL_CALL_COST));
                    break;
                case 3:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration2 = scanner.nextInt();
                    scanner.nextLine();
                    bill.addCall(new Call(CallType.LOCAL, new WeeklyCallCostStrategy(), duration2,
                            WEEKEND_LOCAL_CALL_COST));
                    break;
                case 4:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the country:");
                    String country = scanner.nextLine();
                    bill.addCall(new Call(CallType.NATIONAL, new RegionalCallCostStrategy(), duration3, country,
                            countryRates));
                    break;
                case 5:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration4 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the province:");
                    String province = scanner.nextLine();
                    bill.addCall(new Call(CallType.INTERNATIONAL, new RegionalCallCostStrategy(), duration4, province,
                            stateRates));
                    break;
                default:
                    System.out.println("Invalid Option.");

            }

            System.out.println("Do you want to add another call? (Y/N)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
        }

        scanner.close();

        bill.generateBill();
    }

}
