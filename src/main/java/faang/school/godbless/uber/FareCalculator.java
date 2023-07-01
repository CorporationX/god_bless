package faang.school.godbless.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareFunction) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException("Distance or time can't be negative");
        }
        return fareFunction.apply(distance, time);
    }
}