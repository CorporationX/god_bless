package faang.school.godbless.Sprint_3.Lambda.Uber;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {

    @Test
    public void calculateFareTest() {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;


        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);


        assertEquals((int)(economyTripCost + 1), 18);
        assertEquals((int)(comfortTripCost + 1), 28);
        assertEquals((int)(premiumTripCost + 1), 43);
    }

}