package faang.school.godbless.Uber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> uberX = (distance, time) -> 30 + 2 * time + 8 * distance;
        BiFunction<Double, Double, Double> uberSelect = (distance, time) -> 89 + 3 * time + 6 * distance;

        System.out.println(fareCalculator.calculateFare(8.0, 40.0, uberX));
        System.out.println(fareCalculator.calculateFare(8.0, 40.0, uberSelect));
    }
}
