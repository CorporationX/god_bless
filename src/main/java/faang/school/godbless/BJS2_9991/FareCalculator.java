package faang.school.godbless.BJS2_9991;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double s, double t, BiFunction<Double, Double, Double> calculation) {
        return calculation.apply(s, t);
    }
}
