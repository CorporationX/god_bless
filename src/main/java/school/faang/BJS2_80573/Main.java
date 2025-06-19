package school.faang.BJS2_80573;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
        BiFunction<Double, Double, Double> nightFare = (distance, time) -> 1.2 * (1.3 * distance + 0.7 * time);
        BiFunction<Double, Double, Double> groupFare = (distance, time) -> 0.85 * (1.8 * distance + 1.2 * time);

        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);
        double nightTripCost = fareCalculator.calculateFare(distance, time, nightFare);
        double groupTripCost = fareCalculator.calculateFare(distance, time, groupFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
        System.out.println("Стоимость поездки на тарифе Night: " + nightTripCost);
        System.out.println("Стоимость поездки на тарифе Group: " + groupTripCost);
    }
}
