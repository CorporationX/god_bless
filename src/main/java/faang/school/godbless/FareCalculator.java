package faang.school.godbless;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareStrategy) {
        return fareStrategy.apply(distance, time);
    }
}
