package faang.school.godbless.Uber;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
public class FareCalculator {
    public Integer calculateFare(Double distance, Double time, BiFunction<Double, Double, Integer> price) {
        return  price.apply(distance, time);
    }
}
