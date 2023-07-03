package faang.school.godbless.uber_millionaires;

import java.util.function.BiFunction;

public class FareCalculator {

    public static double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fare) {
        return fare.apply(distance, time);
    }
}
