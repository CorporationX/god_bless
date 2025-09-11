package school.faang.bjs2_89000;

import java.util.function.BiFunction;

public class FareCalculator {

    public Double calculateFare(Double distance, Double time,
                              BiFunction<Double, Double, Double> function) {
        return function.apply(distance, time);
    }
}