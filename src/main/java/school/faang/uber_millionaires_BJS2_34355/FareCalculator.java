package school.faang.uber_millionaires_BJS2_34355;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare (Double distance, Double time, BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(distance, time);
    }
}
