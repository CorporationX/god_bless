package school.faang.millionsuber;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> someFare) {
        return someFare.apply(distance, time);
    }
}
