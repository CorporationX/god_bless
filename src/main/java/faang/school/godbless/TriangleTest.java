package faang.school.godbless;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @ParameterizedTest
    @CsvSource({
            "3.0, 4.0, 5.0, 6.0",
            "6.0, 8.0, 10.0, 24.0",
            "5.0, 12.0, 13.0, 30.0"
    })
    public void testTriangleArea(double a, double b, double c, double expectedArea) {
        Triangle triangle = new Triangle();

        double actualArea = triangle.triangleArea(a, b, c);

        assertEquals(expectedArea, actualArea);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 4.0, 5.0",
            "3.0, -4.0, 5.0",
            "1.0, 1.0, 3.0"
    })
    public void testInvalidTriangle(double a, double b, double c) {
        Triangle triangle = new Triangle();

        assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(a, b, c));
    }
}