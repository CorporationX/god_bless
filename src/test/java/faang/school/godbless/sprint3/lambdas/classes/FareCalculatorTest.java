package faang.school.godbless.sprint3.lambdas.classes;

import faang.school.godbless.sprint3.lambdas.Uber.FareCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareCalculatorTest {
    private static FareCalculator fareCalculator;

    private static BiFunction<Double, Double, Double> economy;
    private static BiFunction<Double, Double, Double> comfort;
    private static BiFunction<Double, Double, Double> premium;


    @BeforeAll
    public static void setUp() {
        fareCalculator = new FareCalculator();
        economy = (distance, time) -> distance * 1.0 + time * 0.5;
        comfort = (distance, time) -> distance * 1.5 + time * 0.8;
        premium = (distance, time) -> distance * 2.0 + time * 1.0;
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    @DisplayName("Test")
    void calculateFare_test(double excepted, BiFunction<Double, Double, Double> function) {
        double distance = 20;
        double time = 30;
        Double result = fareCalculator.calculateFare(distance, time, function);
        assertEquals(excepted, result);
    }

    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(
                        35.0,
                        economy),
                Arguments.of(
                        54.0,
                        comfort),
                Arguments.of(
                        70.0,
                        premium
                )
        );
    }

}