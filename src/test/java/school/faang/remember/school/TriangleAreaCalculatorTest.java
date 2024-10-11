package school.faang.remember.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAreaCalculatorTest {

    private TriangleAreaCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new TriangleAreaCalculator();
    }

    @Test
    public void calculateTriangleAreaTest() {
        Double expected = 6.00;
        Double actual = calculator.calculateTriangleArea(3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionForInvalidTriangleSideTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateTriangleArea(1, 1, 3));
        Assertions.assertEquals("Треугольник с такими сторонами не может существовать.", exception.getMessage());
    }
}
