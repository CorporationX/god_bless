package faang.school.godbless.sprint3.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> function) {
        return function.apply(distance, time);
    }
}
