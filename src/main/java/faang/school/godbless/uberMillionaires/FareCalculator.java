package faang.school.godbless.uberMillionaires;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare(double rideDistance, double rideTime, BiFunction<Double, Double, Double> fareCalculator) {
        return fareCalculator.apply(rideDistance, rideTime);
    }
}
