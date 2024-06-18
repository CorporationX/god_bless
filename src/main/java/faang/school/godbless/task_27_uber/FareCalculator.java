package faang.school.godbless.task_27_uber;

import java.util.function.BiFunction;

public class FareCalculator {

    public Double calculateFare(double distance, double time, BiFunction<Double, Double, Double> function) {
        return function.apply(distance, time);
    }
}
