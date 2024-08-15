package faang.school.godbless.secondsprint.rememberschool;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaCalculatorTest {

    @ParameterizedTest
    @MethodSource("provideTriangleSidesForAreaCalculation")
    @DisplayName("Calculate area for given triangle sides")
    public void testTriangleArea(double a, double b, double c, double expectedArea) {
        double area = TriangleAreaCalculator.triangleArea(a, b, c);
        assertEquals(expectedArea, area, 0.0001);
    }

    @Test
    @DisplayName("Validate for zero or negative side lengths, or invalid triangles")
    public void testInvalidSidesAndTriangles() {
        assertAll(
                () -> {
                    Exception zeroValueException = assertThrows(IllegalArgumentException.class,
                            () -> TriangleAreaCalculator.triangleArea(0, 3, 4));
                    assertEquals("Sides must be positive and non-zero", zeroValueException.getMessage());
                },
                () -> {
                    Exception negativeValueException = assertThrows(IllegalArgumentException.class,
                            () -> TriangleAreaCalculator.triangleArea(-3, 3, 4));
                    assertEquals("Sides must be positive and non-zero", negativeValueException.getMessage());
                },
                () -> {
                    Exception invalidTriangleException = assertThrows(IllegalArgumentException.class,
                            () -> TriangleAreaCalculator.triangleArea(1, 2, 3));
                    assertEquals("The provided sides do not form a valid triangle",
                            invalidTriangleException.getMessage());
                }
        );
    }

    private static Stream<Arguments> provideTriangleSidesForAreaCalculation() {
        return Stream.of(
                Arguments.of(2.0, 2.0, 2.0, Math.sqrt(3)),
                Arguments.of(10.0, 10.0, 10.0, Math.sqrt(3) * 25),
                Arguments.of(3.0, 4.0, 5.0, 6.0)
        );
    }
}
