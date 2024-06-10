package faang.school.godbless.uber_millions;

import java.util.function.BiFunction;

public class FareCalculator {
    double calculateFare(double distance, double time, BiFunction<Double, Double, Double> tariff) {
        return tariff.apply(distance, time);
    }
}
