package school.faang.sprint_2.task_45867;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TriangleAreaCalculatorTest {
    private TriangleAreaCalculator triangleAreaCalculator = new TriangleAreaCalculator();

    @Test
    void testTriangleAreaCalculatorSuccessCase() {
        double expectedArea = 6.0;

        double area = triangleAreaCalculator.calculateTriangleArea(3, 4, 5);

        assertEquals(expectedArea, area);
    }

    @Test
    void testTriangleAreaCalculatorTriangleNotExist() {
        assertThrowsExactly(
                IllegalArgumentException.class,
                () -> triangleAreaCalculator.calculateTriangleArea(1, 2, 5),
                "Треугольник с такими сторонами не существует"
        );
    }

    @Test
    void testTriangleAreaCalculatorWithNegativeSide() {
        assertThrowsExactly(
                IllegalArgumentException.class,
                () -> triangleAreaCalculator.calculateTriangleArea(-1, 2, 5),
                "Треугольник должен иметь положительные стороны"
        );
    }
}
