package faang.school.godbless.UberMillions;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double range, double time, BiFunction<Double, Double, Double> priceCalculation) {
        return priceCalculation.apply(range, time);
    }
}
