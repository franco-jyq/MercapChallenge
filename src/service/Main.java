package service;

import java.util.HashMap;
import java.util.Scanner;

import model.MonthlyBill;
import model.LocalCallCostStrategy;
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
        stateRates.put("MENDOZA", (double) (0.3));

        HashMap<String, Double> countryRates = new HashMap<String, Double>();
        countryRates.put("US", (double) (0.5));
        countryRates.put("ARG", (double) (0.9));

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
                    double duration = scanner.nextInt();
                    scanner.nextLine();
                    bill.addCallCost(new Call(CallType.LOCAL, new LocalCallCostStrategy(WEEKDAY_PEAK_LOCAL_CALL_COST),
                            duration));
                    break;
                case 2:
                    System.out.println("Enter the duration of the call (minutes):");
                    double duration1 = scanner.nextInt();
                    scanner.nextLine();
                    bill.addCallCost(
                            new Call(CallType.LOCAL, new LocalCallCostStrategy(WEEKDAY_OFF_PEAK_LOCAL_CALL_COST),
                                    duration1));
                    break;
                case 3:
                    System.out.println("Enter the duration of the call (minutes):");
                    double duration2 = scanner.nextInt();
                    scanner.nextLine();
                    bill.addCallCost(
                            new Call(CallType.LOCAL, new LocalCallCostStrategy(WEEKEND_LOCAL_CALL_COST), duration2));
                    break;
                case 4:
                    System.out.println("Enter the duration of the call (minutes):");
                    double duration3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the country: (US/ARG)");
                    String country = scanner.nextLine().toUpperCase();
                    bill.addCallCost(new Call(CallType.NATIONAL, new RegionalCallCostStrategy(countryRates, country),
                            duration3));
                    break;
                case 5:
                    System.out.println("Enter the duration of the call (minutes):");
                    double duration4 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the province:(MENDOZA/IOWA)");
                    String province = scanner.nextLine().toUpperCase();
                    bill.addCallCost(
                            new Call(CallType.INTERNATIONAL, new RegionalCallCostStrategy(stateRates, province),
                                    duration4));
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

        System.out.println(bill.generateBill());

    }
}