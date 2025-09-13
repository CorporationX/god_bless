package school.faang.bjs2_87788;

import java.util.function.BiFunction;

public class FareCalculator {

    protected double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareFunction) {
        return fareFunction.apply(distance, time);
    }
}
