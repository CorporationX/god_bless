package faang.school.godbless.schoolAreaOfTriangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaTriangleTest {
    private double a;
    private double b;
    private double c;
    private static final double DELTA = 1e-3;

    @BeforeEach
    void setUp() {
        a = 2;
        b = 3;
        c = 4;
    }

    @Test
    void testTriangleArea() {
        assertEquals(2.904, AreaTriangle.triangleArea(a, b, c), DELTA);
    }

    @Test
    void shouldThrowExceptionBySideA() {
        a = 8;
        Exception exception = assertThrowsExactly(IllegalArgumentException.class,
                () -> AreaTriangle.triangleArea(a, b, c));
        assertEquals("There is no such triangle", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionBySideB() {
        b = 8;
        Exception exception = assertThrowsExactly(IllegalArgumentException.class,
                () -> AreaTriangle.triangleArea(a, b, c));
        assertEquals("There is no such triangle", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionBySideC() {
        c = 8;
        Exception exception = assertThrowsExactly(IllegalArgumentException.class,
                () -> AreaTriangle.triangleArea(a, b, c));
        assertEquals("There is no such triangle", exception.getMessage());
    }
}