package school.faang.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> priceCalculator) {
        return priceCalculator.apply(distance, time);
    }
}
