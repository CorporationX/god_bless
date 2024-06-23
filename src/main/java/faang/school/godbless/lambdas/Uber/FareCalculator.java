package faang.school.godbless.lambdas.Uber;

import lombok.AllArgsConstructor;

import java.util.function.BiFunction;

@AllArgsConstructor
public class FareCalculator {
    public Integer calculateFare(Double distance, Double time, BiFunction<Double, Double, Integer> price) {
        return price.apply(distance, time);
    }
}
