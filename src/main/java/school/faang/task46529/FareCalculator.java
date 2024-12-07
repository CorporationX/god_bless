package school.faang.task46529;

import java.util.function.BiFunction;

public class FareCalculator {
    public int calculateFare(double distance, double time, BiFunction<Double, Double, Integer> biFunction) {
        if (distance <= 0 || time <= 0) {
            throw new IllegalArgumentException("Invalid distance or time");
        }
        if (biFunction == null){
            throw new IllegalArgumentException("Invalid biFunction");
        }
        return biFunction.apply(distance, time);
    }
}
