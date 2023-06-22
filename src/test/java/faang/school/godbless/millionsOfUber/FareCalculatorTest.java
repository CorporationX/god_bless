package faang.school.godbless.millionsOfUber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {
    private FareCalculator fareCalculator;
    private static BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
    private static BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
    private static BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

    @BeforeEach
    void setUp() {
        fareCalculator = new FareCalculator();
    }

    @ParameterizedTest
    @MethodSource("prepareData")
    void testCalculateFare(double distance, double time,
                           BiFunction<Double, Double, Double> function, double expectedResult) {
        assertEquals(expectedResult, fareCalculator.calculateFare(distance, time, function));
    }

    static Stream<Arguments> prepareData() {
        return Stream.of(
                Arguments.of(10, 15, economyFare, 17.5),
                Arguments.of(10, 15, comfortFare, 27),
                Arguments.of(10, 15, premiumFare, 42.5),
                Arguments.of(100, 60, economyFare, 130)
        );
    }
}