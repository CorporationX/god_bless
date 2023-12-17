package faang.school.godbless.UberMillionaires;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(Integer distance, int minutes, BiFunction<Integer, Integer, Double> biFunction) {
       return biFunction.apply(distance,minutes);
    }

}
