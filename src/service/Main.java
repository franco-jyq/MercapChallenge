package service;

import java.util.HashMap;
import java.util.Scanner;

import model.MonthlyBill;
import model.WeekDayOffPeakLocalCallCostStrategy;
import model.WeekDayPeakLocalCallCostStrategy;
import model.WeekEndLocalCallCostStrategy;
import model.InternationalCallCostStrategy;
import model.NationalCallCostStrategy;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyBill bill = new MonthlyBill(10); // Costo básico mensual
        HashMap<String, Float> stateRates = new HashMap<String, Float>();
        stateRates.put("CA", (float) (0.2));

        HashMap<String, Float> countryRates = new HashMap<String, Float>();
        countryRates.put("US", (float) (0.5));

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
            scanner.nextLine(); // Consumir el salto de línea

            switch (callType) {
                case 1:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    bill.setLocalCallStrategy(new WeekDayPeakLocalCallCostStrategy());
                    bill.addLocalCall(duration);
                    break;
                case 2:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration1 = scanner.nextInt();
                    scanner.nextLine();
                    bill.setLocalCallStrategy(new WeekDayOffPeakLocalCallCostStrategy());
                    bill.addLocalCall(duration1);
                    break;
                case 3:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration2 = scanner.nextInt();
                    bill.setLocalCallStrategy(new WeekEndLocalCallCostStrategy());
                    bill.addLocalCall(duration2);
                    break;
                case 4:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the country:");
                    String country = scanner.nextLine();
                    bill.setInternationalCallStrategy(new InternationalCallCostStrategy());
                    bill.addInternationalCall(duration3, country, countryRates);
                    break;
                case 5:
                    System.out.println("Enter the duration of the call (minutes):");
                    int duration4 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the province:");
                    String province = scanner.nextLine();
                    bill.setNationalCallStrategy(new NationalCallCostStrategy());
                    bill.addNationalCall(duration4, province, stateRates);
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
