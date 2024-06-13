package faang.school.godbless.lamdbastreamapi.uber;

import java.util.function.BiFunction;

public class FareCalculator {

    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> calculation) {
        return calculation.apply(distance, time);
    }
}
