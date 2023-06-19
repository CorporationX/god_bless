package faang.school.godbless.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void triangleArea() {
        Triangle triangle = new Triangle();
        Double actual = triangle.triangleArea(10, 10, 12);
        assertEquals(48, actual);
    }
}