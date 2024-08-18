package faang.school.godbless.modul2.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareTypeFunction) {
        return fareTypeFunction.apply(distance, time);
    }
}
