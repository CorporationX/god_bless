package school.faang.m1s2.bjs2_34377_uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, time);
    }
}
