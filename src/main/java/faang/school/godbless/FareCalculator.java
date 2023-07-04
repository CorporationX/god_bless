package faang.school.godbless;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareFunction) {
        return fareFunction.apply(distance, time);
    }
}
