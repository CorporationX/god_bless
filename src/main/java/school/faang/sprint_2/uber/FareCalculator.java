package school.faang.sprint_2.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> tripCost) {
        return tripCost.apply(distance, time);
    }
}
