package Uber_millions;

import java.util.function.BiFunction;

public class FareCalculator {
    public Double calculateFare(Double distance, Double time,
                                BiFunction<Double,Double,Double> fare){
        return fare.apply(distance,time);
    }
}
