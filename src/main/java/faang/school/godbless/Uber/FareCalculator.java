package faang.school.godbless.Uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(double way, double time, BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(way, time);
    }
}
