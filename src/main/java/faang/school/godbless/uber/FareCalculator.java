package main.java.faang.school.godbless.uber;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double time, double distance, BiFunction<Double, Double, Double> function){
       return function.apply(time, distance);
    }
}
