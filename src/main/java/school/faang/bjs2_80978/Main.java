package school.faang.bjs2_80978;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator calculator = new FareCalculator();

        BiFunction<Double, Double, Double> economy = (distance, time) -> 1.0 * distance + 0.4 * time;
        BiFunction<Double, Double, Double> comfort = (distance, time) -> 1.7 * distance + 1.0 * time;
        BiFunction<Double, Double, Double> premium = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        double economyCost = calculator.calculateFare(distance, time, economy);
        double comfortCost = calculator.calculateFare(distance, time, comfort);
        double premiumCost = calculator.calculateFare(distance, time, premium);
        System.out.println("Economy: " + economyCost);
        System.out.println("Comfort: " + comfortCost);
        System.out.println("Premium: " + premiumCost);
    }
}
