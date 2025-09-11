package school.faang.bjs2_89000;

import java.util.function.BiFunction;

public class Main {
    private static final double DISTANCE_KM = 10.0;
    private static final double TIME_MIN = 15.0;

    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double economyTripCost = fareCalculator.calculateFare(DISTANCE_KM, TIME_MIN, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(DISTANCE_KM, TIME_MIN, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(DISTANCE_KM, TIME_MIN, premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
    }
}