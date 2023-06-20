package faang.school.godbless.sprint_3.milionsUber;


import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> function) throws IllegalStateException {
        double result = function.apply(distance, time);
        if (Double.isNaN(result) || result == 0.0) {
            throw new IllegalStateException("Некорректный результат вычислений.");
        }
        return result;
    }
}
