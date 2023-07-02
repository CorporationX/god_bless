package faang.school.godbless.sprint3.uber;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCalculatorTest {
    private FareCalculator fareCalculator = new FareCalculator();
    private double distance = 10.0;
    private double time = 15.0;

    @Test
    public void testEconomyFare() {
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        double tripCost = fareCalculator.calculateFare(distance, time, economyFare);
        assertEquals(17.5, tripCost);
    }

    @Test
    public void testComfortFare() {
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        double tripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        assertEquals(27.0, tripCost);
    }

    @Test
    public void testPremiumFare() {
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
        double tripCost = fareCalculator.calculateFare(distance, time, premiumFare);
        assertEquals(42.5, tripCost);
    }
}
