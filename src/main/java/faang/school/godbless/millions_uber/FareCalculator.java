package faang.school.godbless.millions_uber;

import java.util.function.BiFunction;

public class FareCalculator {

    BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
    BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
    BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;


    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> function) {
        return function.apply(distance, time);
    }
}
