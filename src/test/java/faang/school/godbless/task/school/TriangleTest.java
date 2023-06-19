package faang.school.godbless.task.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void triangleArea_getCorrectAnswer() {
        var s = Triangle.triangleArea(3, 4, 5);
        assertEquals(6, s);
    }

    @Test
    void triangleArea_setZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(0.0, 0.0, 0.0));
        assertEquals(Triangle.EXCEPTION_MESSAGE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(0.0, 1.0, 0.0));
        assertEquals(Triangle.EXCEPTION_MESSAGE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Triangle.triangleArea(2.0, -0.01, 4.0));
        assertEquals(Triangle.EXCEPTION_MESSAGE, exception.getMessage());
    }
}