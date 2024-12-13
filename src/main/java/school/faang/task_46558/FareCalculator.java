package school.faang.task_46558;

import lombok.NonNull;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time,
                                @NonNull BiFunction<Double, Double, Double> biFunction) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException("Distance and time cannot be negative");
        }
        return biFunction.apply(distance, time);
    }

}
