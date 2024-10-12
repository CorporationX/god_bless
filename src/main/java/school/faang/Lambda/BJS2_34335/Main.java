package school.faang.Lambda.BJS2_34335;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        printTripCost("Economy", distance, time, economyFare);
        printTripCost("Comfort", distance, time, comfortFare);
        printTripCost("Premium", distance, time, premiumFare);
    }

    private static void printTripCost(String fareType, double distance, double time,
                                      BiFunction<Double, Double, Double> fareFunction) {
        double tripCost = FareCalculator.calculateFare(distance, time, fareFunction);
        System.out.println("Стоимость поездки на тарифе " + fareType + ": " + tripCost);
    }
}
