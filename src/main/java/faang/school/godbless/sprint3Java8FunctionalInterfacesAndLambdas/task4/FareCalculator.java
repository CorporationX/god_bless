package faang.school.godbless.sprint3Java8FunctionalInterfacesAndLambdas.task4;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> fare) {
        return fare.apply(distance, time);
    }
}
