package MillonUber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> price){
        return price.apply(distance, time);
    }
}
