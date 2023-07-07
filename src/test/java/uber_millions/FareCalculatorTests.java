package uber_millions;

import faang.school.godbless.uber_millions.FareCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

public class FareCalculatorTests {

    private final FareCalculator fareCalculator = new FareCalculator();

    private double economyTripCost;
    private double comfortTripCost;
    private double premiumTripCost;
    private double employeeTripCost;

    private double distance;
    private double time;

    public void setUp() {
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
        BiFunction<Double, Double, Double> employeeFare = (distance, time) -> 0.5 * distance + 0.35 * time;

        distance = 10.0;
        time = 15.0;

        economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);
        employeeTripCost = fareCalculator.calculateFare(distance, time, employeeFare);
    }

    @Test
    @DisplayName("Calculate fare test")
    public void shouldCalculateFare() {
        double expectedEconomyCost = distance + 0.5 * time;
        double expectedComfortCost = 1.5 * distance + 0.8 * time;
        double expectedPremiumCost = 2.0 * distance + 1.5 * time;
        double expectedEmployeeCost = 0.5 * distance + 0.35 * time;

        Assertions.assertEquals(expectedEconomyCost, economyTripCost);
        Assertions.assertEquals(expectedComfortCost, comfortTripCost);
        Assertions.assertEquals(expectedPremiumCost, premiumTripCost);
        Assertions.assertEquals(expectedEmployeeCost, employeeTripCost);
    }
}
