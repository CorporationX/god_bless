package faang.school.godbless.millions_uber;

import java.util.function.BiFunction;

public class FareCalculator {

    double calculateFare(double distance, double cost, BiFunction<Double, Double, Double> function) {
        return function.apply(distance, cost);
    }
}