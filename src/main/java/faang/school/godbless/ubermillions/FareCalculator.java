package faang.school.godbless.ubermillions;

import java.util.function.BiFunction;

public class FareCalculator {

    public Double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, time);
    }
}
