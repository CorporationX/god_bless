package school.faang.uber.millionaires;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare(Double distance, Double travelTime, BiFunction<Double, Double, Double> calculateFunction) {
        return calculateFunction.apply(distance, travelTime);
    }
}
