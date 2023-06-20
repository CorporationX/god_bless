package faang.school.godbless.uber;

import java.util.function.BiFunction;

public class Application {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 10.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 15.0 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 20.0 * distance + 1.5 * time;
        BiFunction<Double, Double, Double> vipFare = (distance, time) -> 50.0 * distance + 3 * time;

        double distance = 25;
        double time = 20;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);
        double vipTripCost = fareCalculator.calculateFare(distance, time, vipFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
        System.out.println("Стоимость поездки на тарифе VIP: " + vipTripCost);
    }
}
