package school.faang.ubercosttrip;

import lombok.NoArgsConstructor;

import java.util.function.BiFunction;

@NoArgsConstructor
public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareCalculation) {
        return fareCalculation.apply(distance, time);
    }
}

