package faang.school.godbless.uber;

import java.util.function.BiFunction;

public class App {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        try {
            double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
            double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
            double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

            System.out.println("Price of Economy: " + economyTripCost);
            System.out.println("Price of Comfort: " + comfortTripCost);
            System.out.println("Price of Premium: " + premiumTripCost);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
