package school.faang.bjs2_88006;

import java.util.function.BiFunction;

public class FareCalculator {
    public static int calculateFare(int distance, int time, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(distance, time);
    }
}
