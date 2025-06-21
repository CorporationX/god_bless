package school.faang.bjs2_80978;

import java.util.function.BiFunction;

public class Main {
    private static final BiFunction<Double, Double, Double> ECONOMY_INITIALIZATION
            = (DISTANCE_INITIALIZATION, TIME_INITIALIZATION) -> 1.0 * DISTANCE_INITIALIZATION + 0.4 * TIME_INITIALIZATION;
    private static final BiFunction<Double, Double, Double> COMFORT_INITIALIZATION
            = (DISTANCE_INITIALIZATION, TIME_INITIALIZATION) -> 1.7 * DISTANCE_INITIALIZATION + 1.0 * TIME_INITIALIZATION;
    private static final BiFunction<Double, Double, Double> PREMIUM_INITIALIZATION
            = (DISTANCE_INITIALIZATION, TIME_INITIALIZATION) -> 2.0 * DISTANCE_INITIALIZATION + 1.5 * TIME_INITIALIZATION;

    private static final double DISTANCE_INITIALIZATION = 10.0;
    private static final double TIME_INITIALIZATION = 15.0;

    public static void main(String[] args) {
        FareCalculator calculator = new FareCalculator();

        double economyCost
                = calculator.calculateFare(DISTANCE_INITIALIZATION, TIME_INITIALIZATION, ECONOMY_INITIALIZATION);
        double comfortCost
                = calculator.calculateFare(DISTANCE_INITIALIZATION, TIME_INITIALIZATION, COMFORT_INITIALIZATION);
        double premiumCost
                = calculator.calculateFare(DISTANCE_INITIALIZATION, TIME_INITIALIZATION, PREMIUM_INITIALIZATION);

        System.out.println("Economy: " + economyCost);
        System.out.println("Comfort: " + comfortCost);
        System.out.println("Premium: " + premiumCost);
    }
}
