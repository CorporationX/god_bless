package faang.school.godbless.sprint3.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SchoolTest {

    static Stream<Arguments> getValidTriangleParams() {
        return Stream.of(
                Arguments.of(3, 3, 3),
                Arguments.of(13.5, 12.7, 20.0),
                Arguments.of(331.5, 313.7, 377.1)
            );
    }

    @ParameterizedTest
    @MethodSource("getValidTriangleParams")
    void triangleArea_shouldMatch(double a, double b, double c) {
        double pDiv2 = (a + b + c) / 2;
        double expected = Math.sqrt(
                pDiv2 * (pDiv2 - a) * (pDiv2 - b) * (pDiv2 - c)
        );
        assertEquals(expected, new School().triangleArea(a, b, c));
    }

    @Test
    void triangleArea_shouldThrowIAException() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class,
                    () -> new School().triangleArea(3, 3, 6),
                    "Invalid input data");
            assertThrows(IllegalArgumentException.class,
                    () -> new School().triangleArea(0,2, 3),
                    "Sides of a triangle cannot be zero");
        });
    }
}