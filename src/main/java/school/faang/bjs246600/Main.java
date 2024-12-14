package school.faang.bjs246600;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.2 + time;
        BiFunction<Double, Double, Double> comfortFare  = (distance, time) -> 1.1 * distance + 0.4 + time;
        BiFunction<Double, Double, Double> premiumFare  = (distance, time) -> 1.2 * distance + 0.6 + time;

        double distance = 10.0;
        double time = 20.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("Cost of the trip according to the fare Economy: " + economyTripCost);
        System.out.println("Cost of the trip according to the fare Comfort: " + comfortTripCost);
        System.out.println("Cost of the trip according to the fare Premium: " + premiumTripCost);
    }
}