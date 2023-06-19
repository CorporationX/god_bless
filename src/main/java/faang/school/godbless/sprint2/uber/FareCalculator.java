package faang.school.godbless.sprint2.uber;

import java.util.Date;
import java.util.function.BiFunction;

public class FareCalculator {
    public static double calculateFare (double distance, double time, BiFunction<Double, Double, Double> function){
        return function.apply(distance,time);
    }
}
