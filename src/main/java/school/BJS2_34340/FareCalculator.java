package school.BJS2_34340;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double,Double,Double> biFunction) {
        return biFunction.apply(distance,time);
    }
}