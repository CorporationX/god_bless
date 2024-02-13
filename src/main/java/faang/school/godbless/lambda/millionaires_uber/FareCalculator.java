package faang.school.godbless.lambda.millionaires_uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare(double distance, double time, BiFunction<Double, Double,Double> priceAlgorithm){
        return priceAlgorithm.apply(distance, time);
    }
}
