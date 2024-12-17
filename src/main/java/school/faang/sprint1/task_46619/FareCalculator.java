package school.faang.sprint1.task_46619;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> resultFunction) {
        return resultFunction.apply(distance, time);

    }
}
