package bjs2_33398;

import java.util.function.BiFunction;

public class FareCalculator {

    public int calculateFare(int travelDistance, int travelTime,
                              BiFunction<Integer, Integer, Integer> calculatePrice) {
        return calculatePrice.apply(travelDistance, travelTime);
    }
}
