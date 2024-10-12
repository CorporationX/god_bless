package ru.kraiush.BJS2_34360;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, int timeInMinutes, BiFunction<Double, Integer, Double> calculator) {
        return calculator.apply(distance, timeInMinutes);
    }
}
