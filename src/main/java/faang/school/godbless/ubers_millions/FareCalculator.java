package faang.school.godbless.ubers_millions;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> countPrice){
       return countPrice.apply(distance, time);
    }
}
