package school.faang.task_47188;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> economyFare) {
        return economyFare.apply(distance, time);
    }
}
