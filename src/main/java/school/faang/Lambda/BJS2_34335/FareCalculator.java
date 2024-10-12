package school.faang.Lambda.BJS2_34335;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare(double distance, double timeTrip, BiFunction<Double, Double, Double> fareFunction) {
        return fareFunction.apply(distance, timeTrip);
    }
}
