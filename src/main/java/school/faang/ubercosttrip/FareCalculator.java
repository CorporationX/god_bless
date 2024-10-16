package school.faang.ubercosttrip;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareCalculation) {
        return fareCalculation.apply(distance, time);
    }
}

