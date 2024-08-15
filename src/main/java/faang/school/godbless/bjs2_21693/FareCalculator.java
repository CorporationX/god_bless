package faang.school.godbless.bjs2_21693;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fare) {
        return fare.apply(distance, time);
    }
}
