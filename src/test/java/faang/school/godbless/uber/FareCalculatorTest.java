package faang.school.godbless.uber;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {

    @Test
    void testCalculateFare() {
        BiFunction<Double, Double, Double> uberX = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> uberSelect = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> uberBlack = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        double uberXTripCost = FareCalculator.calculateFare(distance, time, uberX);
        double uberSelectTripCost = FareCalculator.calculateFare(distance, time, uberSelect);
        double uberBlackTripCost = FareCalculator.calculateFare(distance, time, uberBlack);

        assertEquals(17.5, uberXTripCost);
        assertEquals(27.0, uberSelectTripCost);
        assertEquals(42.5, uberBlackTripCost);
    }
}