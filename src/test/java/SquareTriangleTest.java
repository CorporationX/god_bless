import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTriangleTest {

    @Test
    void triangleArea() {
        double value = SquareTriangle.triangleArea(5, 5, 5);
        double result = Math.round(value * 100.0) / 100.0;

        assertEquals(10.83, result);
    }

    @Test
    void IllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> SquareTriangle.triangleArea(5, 0, 5));
    }
}