package faang.school.godbless.ubermillions;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> tarif) {
        return  tarif.apply(distance, time);
    }
}
