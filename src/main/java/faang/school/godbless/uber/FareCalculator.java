package faang.school.godbless.uber;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> function) {
        validateFunction(function);
        validateDoubleInput(distance, "Distance");
        validateDoubleInput(time, "Time");

        return function.apply(distance, time);
    }

    private void validateDoubleInput(double number, String argumentType) {
        if (number <= 0) {
            throw new IllegalArgumentException(argumentType + " can't be equals or less than 0");
        }
    }

    private void validateFunction(BiFunction<Double, Double, Double> function) {
        if (function == null) {
            throw new IllegalArgumentException("Function can't be null");
        }
    }
}
