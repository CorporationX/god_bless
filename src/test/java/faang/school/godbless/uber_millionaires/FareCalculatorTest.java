package faang.school.godbless.uber_millionaires;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {

    @Test
    void testCalculateFare() {
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = FareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = FareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = FareCalculator.calculateFare(distance, time, premiumFare);

        assertEquals(17.5, economyTripCost);
        assertEquals(27.0, comfortTripCost);
        assertEquals(42.5, premiumTripCost);
    }
}