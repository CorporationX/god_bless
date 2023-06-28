package LambdaStream.bc1112;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(distance, time);
    }
}
