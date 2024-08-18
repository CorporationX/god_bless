package faang.school.godbless.bjs2_21693;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareCalculatorTest {
    private final FareCalculator fareCalculator = new FareCalculator();

    @Test
    void testCalculateFare() {
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double economyTripCost = fareCalculator.calculateFare(1, 1, economyFare);
        assertEquals(1.5, economyTripCost);
        double comfortTripCost = fareCalculator.calculateFare(1, 1, comfortFare);
        assertEquals(2.3, comfortTripCost);
        double premiumTripCost = fareCalculator.calculateFare(1, 1, premiumFare);
        assertEquals(3.5, premiumTripCost);
    }
}