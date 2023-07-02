package faang.school.godbless.uber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UberTest {
    private FareCalculator fareCalculator;
    private BiFunction<Double, Double, Double> childFare;
    private BiFunction<Double, Double, Double> economyFare;
    private BiFunction<Double, Double, Double> comfortFare;
    private BiFunction<Double, Double, Double> premiumFare;

    @BeforeEach
    public void setUp() {
        fareCalculator = new FareCalculator();
        childFare = (distance, time) -> 0.8 * distance + 0.4 * time;
        economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
    }

    @Test
    public void testCalculateFare() {
        double distanceOne = 10.0;
        double timeOne = 15.0;
        double childTripCost = fareCalculator.calculateFare(distanceOne, timeOne, childFare);
        double economyTripCost = fareCalculator.calculateFare(distanceOne, timeOne, economyFare);
        assertEquals(childTripCost, 14.0);
        assertEquals(economyTripCost, 17.5);

        double distanceTwo = 100.0;
        double timeTwo = 120.0;
        double comfortTripCost = fareCalculator.calculateFare(distanceTwo, timeTwo, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distanceTwo, timeTwo, premiumFare);
        assertEquals(comfortTripCost, 246.0);
        assertEquals(premiumTripCost, 380.0);
    }
}
