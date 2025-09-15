package school.faang.bjs2_88006;

import java.util.function.BiFunction;

public class FareCalculator {
    public static int calculateFare(
            int distanceKm, int timeMinutes, BiFunction<Integer, Integer, Integer> fareFunction) {
        return fareFunction.apply(distanceKm, timeMinutes);
    }
}
