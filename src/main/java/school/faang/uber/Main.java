package school.faang.uber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.3 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortPlusFare = (distance, time) -> 2.0 * distance + 0.7 * time;
        BiFunction<Double, Double, Double> businessFare = (distance, time) -> 2.5 * distance + 1.0 * time;

        double distance = 5.0;
        double time = 10.0;

        double economyFareCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortFareCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double comfortPlusFareCost = fareCalculator.calculateFare(distance, time, comfortPlusFare);
        double businessFareCost = fareCalculator.calculateFare(distance, time, businessFare);

        System.out.println("The cost of the trip on the Economy fare: " + economyFareCost);
        System.out.println("The cost of the trip on the Comfort fare: " + comfortFareCost);
        System.out.println("The cost of the trip on the Comfort plus fare: " + comfortPlusFareCost);
        System.out.println("The cost of the trip on the Business fare: " + businessFareCost);
    }
}
