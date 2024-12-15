package school.faang.bjs246600;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculation) {
        return calculation.apply(distance, time);
    }
}