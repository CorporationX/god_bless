package faang.school.godbless.Sprint_3.Uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunc) {
        return biFunc.apply(distance, time);
    }
}
