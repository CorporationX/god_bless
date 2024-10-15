package school.faang.secondStream.BJS2_34364;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double tripTime, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, tripTime);
    }
}
