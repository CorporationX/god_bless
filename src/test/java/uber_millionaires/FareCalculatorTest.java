package uber_millionaires;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareCalculatorTest {
    private final FareCalculator FARE_CALCULATOR = new FareCalculator();

    private final BiFunction<Double, Double, Double> ECONOMY_FARE = (distance, time) -> 1.0 * distance + 0.5 * time;
    private final BiFunction<Double, Double, Double> COMFORT_FARE = (distance, time) -> 1.5 * distance + 0.8 * time;
    private final BiFunction<Double, Double, Double> PREMIUM_FARE = (distance, time) -> 2.0 * distance + 1.5 * time;

    @Test
    void calculateFare() {
        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = FARE_CALCULATOR.calculateFare(distance, time, ECONOMY_FARE);
        double comfortTripCost = FARE_CALCULATOR.calculateFare(distance, time, COMFORT_FARE);
        double premiumTripCost = FARE_CALCULATOR.calculateFare(distance, time, PREMIUM_FARE);

        assertEquals(17.5, economyTripCost);
        assertEquals(27.0, comfortTripCost);
        assertEquals(42.5, premiumTripCost);
    }
}