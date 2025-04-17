package school.faang.bjs2_70443;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double duration, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, duration);
    }
}