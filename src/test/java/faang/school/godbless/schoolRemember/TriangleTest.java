package faang.school.godbless.schoolRemember;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    void testTriangleAreaResult() {
        Assertions.assertEquals(43.30127018922193, triangle.triangleArea(10, 10, 10));
    }

    @Test
    void testThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(50, 10, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(1, 10, 50));
        Assertions.assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(10, 50, 1));
    }
}