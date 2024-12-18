package derschrank.sprint02.task15.bjstwo_46577;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, time);
    }
}
