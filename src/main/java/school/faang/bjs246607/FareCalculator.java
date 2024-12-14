package school.faang.bjs246607;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunction) {
        if (distance == 0 || time == 0 || biFunction == null) {
            throw new NullPointerException("Argument must be not null");
        }
        return biFunction.apply(distance, time);
    }
}
