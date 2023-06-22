package faang.school.godbless.sprint3.uber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FareCalculatorTest {
    private BiFunction<Double, Double, Double> economyFare;
    private BiFunction<Double, Double, Double> comfortFare;
    private BiFunction<Double, Double, Double> premiumFare;

    @BeforeEach
    void setFares() {
        economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void calculateFare(double distance, double time, double economyCost, double comfortCost, double premiumCost) {
        FareCalculator fareCalculator = new FareCalculator();
        assertAll(() -> {
            assertEquals(fareCalculator.calculateFare(distance, time, economyFare), economyCost);
            assertEquals(fareCalculator.calculateFare(distance, time, comfortFare), comfortCost);
            assertEquals(fareCalculator.calculateFare(distance, time, premiumFare), premiumCost);
        });
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(10, 15, 17.5, 27, 42.5),
                Arguments.of(20, 30, 35, 54, 85)
        );
    }
}