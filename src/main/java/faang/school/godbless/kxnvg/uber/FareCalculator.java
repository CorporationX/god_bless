package faang.school.godbless.kxnvg.uber;

import java.util.function.BiFunction;

public class FareCalculator {

    public Double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunction) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException("Введены неверные параметры времени/расстояния");
        }

        return biFunction.apply(distance, time);
    }
}
