package faang.school.godbless.uber_millions;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> fare) {
        return fare.apply(distance, time);
    }
}
