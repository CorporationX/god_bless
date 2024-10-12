package school.faang.uber.millionaires;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareCalculatorTest {
    BiFunction<Double, Double, Double> economyFare;
    BiFunction<Double, Double, Double> comfortFare;
    BiFunction<Double, Double, Double> premiumFare;
    BiFunction<Double, Double, Double> defaultFare;

    @BeforeEach
    public void setUp() {
        economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
        defaultFare = (distance, time) -> 1.0 * distance + 1.0 * time;
    }

    @ParameterizedTest()
    @CsvSource({
            "10.0, 15.0, economy, 17.5",
            "10.0, 15.0, comfort, 27.0",
            "10.0, 15.0, premium, 42.5",
            "10.0, 15.0, incorrect, 25.0"
    })
    public void calculateFareTest(double distance, double time, String fareType, double expectedFare) {
        assertEquals(expectedFare, FareCalculator.calculateFare(distance, time, getFareFunctionByType(fareType)));
    }

    private BiFunction<Double, Double, Double> getFareFunctionByType(String fareType) {
        return switch (fareType) {
            case "economy" -> economyFare;
            case "comfort" -> comfortFare;
            case "premium" -> premiumFare;
            default -> defaultFare;
        };
    }
}
