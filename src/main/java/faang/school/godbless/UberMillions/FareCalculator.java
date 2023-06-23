package faang.school.godbless.UberMillions;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> biFunction) {
        if(distance == null || time == null){
            throw new NullPointerException();
        }
        return biFunction.apply(distance,time);
    }
}
