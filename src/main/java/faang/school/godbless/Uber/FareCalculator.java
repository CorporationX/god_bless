package faang.school.godbless.Uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(Double range, Double time, BiFunction<Double, Double, Double> calculate){
       return calculate.apply(range, time);
    }
}
