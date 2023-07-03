package faang.school.godbless.sprint3.lambda.task10;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunction) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException("Введены неправильные данные");
        }
        if (biFunction == null) {
            throw new NullPointerException("BiFunction не может быть null");
        }
        return biFunction.apply(distance, time);
    }
}

