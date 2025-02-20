package school.faang.BJS2_57708;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double travelTime, BiFunction<Double, Double, Double> costFunction) {
        return costFunction.apply(distance, travelTime);
    }
}
