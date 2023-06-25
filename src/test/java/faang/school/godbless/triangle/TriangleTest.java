package faang.school.godbless.triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void triangleAreaValidTest() {
        double area1 = Triangle.triangleArea(3.0, 4.0, 5.0);
        double area2 = Triangle.triangleArea(6.0, 8.0, 10.0);
        double area3 = Triangle.triangleArea(12, 5, 13);

        assertEquals(6.0, area1);
        assertEquals(24.0, area2);
        assertEquals(30, area3);
    }

    @Test
    void triangleAreaInvalidTest() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(0, 2.0, 8.10));
        assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(-1, 99, 10));
        assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(2.0, 9.0, 3.0));
    }
}