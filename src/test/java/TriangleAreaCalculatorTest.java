import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static school.faang.TriangleAreaCalculator.calculateTriangleArea;

public class TriangleAreaCalculatorTest {
    @Test
    public void testCalculateTriangleArea_basicCase() {
        double a = 3;
        double b = 4;
        double c = 5;
        double area = calculateTriangleArea(a, b, c);
        assertEquals(6.0, area, 0.0001);
    }

    @Test
    public void testCalculateTriangleArea_invalidTriangle() {
        double a = 1;
        double b = 2;
        double c = 3;
        assertThrows(IllegalArgumentException.class, () -> calculateTriangleArea(a, b, c));
    }

    @Test
    public void testCalculateTriangleArea_withNegativeSide() {
        double a = -3;
        double b = 4;
        double c = 5;
        assertThrows(IllegalArgumentException.class, () -> calculateTriangleArea(a, b, c));
    }

    @Test
    public void testInvalidTriangle_ZeroSide() {
        double a = 0;
        double b = 4;
        double c = 5;
        assertThrows(IllegalArgumentException.class, () -> calculateTriangleArea(a, b, c));
    }
}
