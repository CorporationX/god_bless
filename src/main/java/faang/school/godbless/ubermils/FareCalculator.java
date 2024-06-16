package faang.school.godbless.ubermils;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fareCalc){
        return fareCalc.apply(distance,time);
    }
}
