package bjs2_33398;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Integer, Integer, Integer> calculateEconomyPrice =
                (travelDistance, travelTime) -> 200 + travelTime * 5 + travelDistance * 5;
        BiFunction<Integer, Integer, Integer> calculateComfortPrice =
                (travelDistance, travelTime) -> 300 + travelTime * 7 + travelDistance * 7;
        BiFunction<Integer, Integer, Integer> calculateBusinessPrice =
                (travelDistance, travelTime) -> 500 + travelTime * 10 + travelDistance * 10;

        System.out.println(fareCalculator.calculateFare(30, 15, calculateEconomyPrice));
        System.out.println(fareCalculator.calculateFare(60, 40, calculateComfortPrice));
        System.out.println(fareCalculator.calculateFare(80, 60, calculateBusinessPrice));
    }
}
