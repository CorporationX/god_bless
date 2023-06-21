package faang.school.godbless.sprint3.Uber.classes;

import java.util.function.BiFunction;

public class FareCalculator {

    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(distance, time);
    }
}
