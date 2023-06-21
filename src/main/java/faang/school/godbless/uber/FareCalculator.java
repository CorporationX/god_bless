package faang.school.godbless.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare(double distance, double time, BiFunction<Double, Double, Double> tariff) {
        return tariff.apply(distance, time);
    }
}
