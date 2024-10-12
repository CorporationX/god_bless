package ru.kraiush.BJS2_34360;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Integer, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Integer, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Integer, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.4;
        int time = 15;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("Cost of a trip on Economy fare: " + economyTripCost);
        System.out.println("Cost of a trip on Comfort fare: " + comfortTripCost);
        System.out.println("Cost of a trip on Premium fare: " + premiumTripCost);
    }
}
