package lets_remember_the_school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleAreaCalculatorTest {
    private final TriangleAreaCalculator CALCULATOR = new TriangleAreaCalculator();

    @Test
    void calculateTriangleArea() {
        double area = CALCULATOR.calculateTriangleArea(3, 4, 5);
        assertEquals(6.0, area);
    }

    @Test
    void calculateTriangleAreaWithError() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> CALCULATOR.calculateTriangleArea(1, 1, 0));
        assertEquals("Треугольник с такими сторонами не может существовать", exception.getMessage());
    }
}