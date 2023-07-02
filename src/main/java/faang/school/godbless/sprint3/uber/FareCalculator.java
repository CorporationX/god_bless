package faang.school.godbless.sprint3.uber;

import lombok.NoArgsConstructor;

import java.util.function.BiFunction;

@NoArgsConstructor
public class FareCalculator {
    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> fareCalculator) {
        return fareCalculator.apply(distance, time);
    }
}
