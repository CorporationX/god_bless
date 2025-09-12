package school.faang.bjs2_89000;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(Double distance, Double time,
                              BiFunction<Double, Double, Double> fareFunction) {
        return fareFunction.apply(distance, time);
    }
}