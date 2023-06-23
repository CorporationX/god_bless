package millions_uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> result) {
        return result.apply(distance, time);
    }
}
