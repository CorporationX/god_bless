package millionsUber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, time);
    }
}
