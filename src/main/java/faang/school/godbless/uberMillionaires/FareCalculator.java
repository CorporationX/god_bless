package faang.school.godbless.uberMillionaires;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare(double distanceRide, double timeRide, BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(distanceRide, timeRide);
    }
}
