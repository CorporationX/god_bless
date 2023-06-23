package millions_uber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

class FareCalculatorTest {

    private FareCalculator fareCalculator;
    private double distance;
    private double time;

    @BeforeEach
    public void setUp() {
        fareCalculator = new FareCalculator();
        distance = 10.0;
        time = 15.0;
    }

    @Test
    public void testEconomyFare() {
        BiFunction<Double, Double, Double> economyFare = (d, t) -> (1.0 * d) + (0.5 * t);
        double expectedCost = distance + (0.5 * time);

        double actualCost = fareCalculator.calculateFare(distance, time, economyFare);

        Assertions.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void testComfortFare() {
        BiFunction<Double, Double, Double> comfortFare = (d, t) -> (1.5 * d) + (0.8 * t);
        double expectedCost = (distance * 1.5) + (time * 0.8);

        double actualCost = fareCalculator.calculateFare(distance, time, comfortFare);

        Assertions.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void testPremiumFare() {
        BiFunction<Double, Double, Double> premiumFare = (d, t) -> (2.0 * d) + (1.5 * t);
        double expectedCost = (distance * 2.0) + (time * 1.5);

        double actualCost = fareCalculator.calculateFare(distance, time, premiumFare);

        Assertions.assertEquals(expectedCost, actualCost);
    }
}