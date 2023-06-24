package faang.school.godbless.sprint2.ubers_millions;

import java.util.function.BiFunction;

public class FareCalculator {
        public Double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> biFunction) {
            return biFunction.apply(distance,time);
        }
}
