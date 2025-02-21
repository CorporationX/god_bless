package school.faang.ubermillions;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;

@Slf4j
public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> formula) {
        checkDoubleValue(distance);
        checkDoubleValue(time);
        return formula.apply(distance, time);
    }

    private void checkDoubleValue(double value) {
        if (value == 0) {
            log.error("Value is zero");
            throw new IllegalArgumentException("Value is zero");
        }
    }
}
