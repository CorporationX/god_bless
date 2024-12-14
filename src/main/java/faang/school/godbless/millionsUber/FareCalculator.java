package faang.school.godbless.millionsUber;

import java.util.function.BiFunction;

public class FareCalculator {
    int calculateFare(int distance, int time, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(distance, time);
    }


}
