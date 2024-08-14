package uber.calc;

import lombok.NonNull;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, @NonNull BiFunction<Double, Double, Double> fare) {
        return fare.apply(distance, time);
    }
}
