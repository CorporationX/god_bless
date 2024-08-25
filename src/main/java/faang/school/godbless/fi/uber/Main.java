package faang.school.godbless.fi.uber;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        // Создание тарифов
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        // Примеры поездок
        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("> Economy ride cost: " + economyTripCost);
        System.out.println("> Comfort ride cost: " + comfortTripCost);
        System.out.println("> Premium ride cost: " + premiumTripCost);
    }

}