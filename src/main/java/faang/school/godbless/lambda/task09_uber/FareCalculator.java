package faang.school.godbless.lambda.task09_uber;

import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public class FareCalculator {

    Double distance;
    Double time;
    public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> biFunction){
        double result = biFunction.apply(distance, time);
        return result;
    }
}
