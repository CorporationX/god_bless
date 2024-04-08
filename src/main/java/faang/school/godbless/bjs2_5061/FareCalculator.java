package faang.school.godbless.bjs2_5061;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> funcFare ) {
        return funcFare.apply(distance, time);
    }
}
