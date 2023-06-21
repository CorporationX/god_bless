package faang.school.godbless.kxnvg.triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private Triangle triangle = new Triangle();

    @Test
    void calculationTriangleArea() {
        double actual = triangle.triangleArea(5,3, 4);
        double expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    void calculationTriangleAreaWithIncorrectSide() {
        assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(8, 3, 4));
    }

    @Test
    void calculationTriangleAreaWithIncorrectInputs() {
        assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(4, 2, 0));
    }
  
}