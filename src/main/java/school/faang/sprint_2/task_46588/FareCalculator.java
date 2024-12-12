package school.faang.sprint_2.task_46588;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> tariff) {
        return tariff.apply(distance, time);
    }
}
