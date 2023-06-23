package faang.school.godbless.uber;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareCalculatorTest {

    @Test
    void calculateFareTest() {
        FareCalculator fareCalculator = new FareCalculator();
        // Создание тарифов
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        // Примеры поездок
        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        double expectedEconomyFare = 10.0 + 0.5 * 15.0;
        double actualEconomyFare = fareCalculator.calculateFare(distance, time, economyFare);
        assertEquals(expectedEconomyFare, actualEconomyFare,
            "Стоимость поездки на тарифе Economy: " + economyTripCost);

        double expectedComfortFare = 1.5 * 10.0 + 0.8 * 15.0;
        double actualComfortFare = fareCalculator.calculateFare(distance, time, comfortFare);
        assertEquals(expectedComfortFare, actualComfortFare,
            "Стоимость поездки на тарифе Comfort: " + comfortTripCost);

        double expectedPremiumFare = 2.0 * 10.0 + 1.5 * 15.0;
        double actualPremiumFare = fareCalculator.calculateFare(distance, time, premiumFare);
        assertEquals(expectedPremiumFare, actualPremiumFare,
            "Стоимость поездки на тарифе Premium: " + premiumTripCost);
    }
}