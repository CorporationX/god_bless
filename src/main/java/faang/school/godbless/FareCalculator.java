package faang.school.godbless;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> rate) {
        return rate.apply(distance, time);
    }
}