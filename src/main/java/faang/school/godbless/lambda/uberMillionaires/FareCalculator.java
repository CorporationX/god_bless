package faang.school.godbless.lambda.uberMillionaires;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunction) {
        if (biFunction == null) {
            throw new IllegalArgumentException("Объект biFunction равен null!");
        }
        return biFunction.apply(distance, time);
    }
}
