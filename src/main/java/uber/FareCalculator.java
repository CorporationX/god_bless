package uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> calculate){
        return calculate.apply(distance, time);
    }
}
