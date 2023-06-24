package sprint3.lambda.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fare) {
        return fare.apply(distance, time);
    }
}
