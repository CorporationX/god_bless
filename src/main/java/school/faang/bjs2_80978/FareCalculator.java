package school.faang.bjs2_80978;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> count) {
        return count.apply(distance,time);
    }
}
