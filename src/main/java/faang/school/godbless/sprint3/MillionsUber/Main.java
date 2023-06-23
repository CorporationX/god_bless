package faang.school.godbless.sprint3.MillionsUber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        Trip trip = new Trip(10.0, 15.0);

        double economyTripCost = fareCalculator.calculateFare(trip.getDistance(), trip.getTime(), economyFare);
        double comfortTripCost = fareCalculator.calculateFare(trip.getDistance(), trip.getTime(), comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(trip.getDistance(), trip.getTime(), premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
    }
}
