package faang.school.godbless.school_triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleAreaCalculatorTest {

    TriangleAreaCalculator tac;

    @BeforeEach
    public void setUp() {
        tac = new TriangleAreaCalculator();
    }

    @Test
    public void testTriangleAreaCalculator() {
        Assertions.assertEquals(6.0, tac.triangleArea(3, 4, 5));
    }

    @Test
    public void testTriangleAreaValidator() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> tac.triangleArea(1.5, 3, 5));
    }
}
