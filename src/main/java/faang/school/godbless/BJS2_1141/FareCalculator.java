package faang.school.godbless.BJS2_1141;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculatePrice) {
        return calculatePrice.apply(distance, time);
    }
}