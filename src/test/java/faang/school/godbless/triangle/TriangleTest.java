package faang.school.godbless.triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void triangleAreaTest() {
        double a = 12, b = 8, c = 6;
        assertEquals(21, Math.round(Triangle.triangleArea(a, b, c)));
    }

    @Test
    void testValidationWithNegativeValue() {
        double a = -8, b = 8, c = 6;
        assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(a, b, c));
    }

    @Test
    void testValidationWithIllegalParam() {
        double a = 2, b = 10, c = 7;
        assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(a, b, c));
    }
}