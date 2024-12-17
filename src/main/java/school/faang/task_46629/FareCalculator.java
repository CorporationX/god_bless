package school.faang.task_46629;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculating) {
        return calculating.apply(distance, time);
    }
}
