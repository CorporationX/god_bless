package school.faang.bjs2_80978;

import java.util.function.BiFunction;

public class Main {
    private static final BiFunction<Double, Double, Double> ECONOMY
            = (DISTANCE, TIME) -> 1.0 * DISTANCE + 0.4 * TIME;
    private static final BiFunction<Double, Double, Double> COMFORT
            = (DISTANCE, TIME) -> 1.7 * DISTANCE + 1.0 * TIME;
    private static final BiFunction<Double, Double, Double> PREMIUM
            = (DISTANCE, TIME) -> 2.0 * DISTANCE + 1.5 * TIME;

    private static final double DISTANCE = 10.0;
    private static final double TIME = 15.0;

    public static void main(String[] args) {
        FareCalculator calculator = new FareCalculator();

        double economyCost = calculator.calculateFare(DISTANCE, TIME, ECONOMY
        );
        double comfortCost = calculator.calculateFare(DISTANCE, TIME, COMFORT);
        double premiumCost = calculator.calculateFare(DISTANCE, TIME, PREMIUM);
        System.out.println("Economy: " + economyCost);
        System.out.println("Comfort: " + comfortCost);
        System.out.println("Premium: " + premiumCost);
    }
}
