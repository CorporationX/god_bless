package school.faang.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(distance, time);
    }
}
