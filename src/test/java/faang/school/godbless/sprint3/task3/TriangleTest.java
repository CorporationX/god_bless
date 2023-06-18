package faang.school.godbless.sprint3.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testTriangleArea() {
        double expected = 6;

        double actual = Triangle.triangleArea(3.0, 5.0, 4.0);

        assertEquals(expected, actual);
    }

}