package faang.school.godbless.back_to_school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaCalculatorTest {

    private TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    void testTriangleAreaMethod_ShouldThrowException_ifSidesAreEqualsOrLessThanZero(){
        String message = "Invalid triangle side length. Sides length must be positive.";

        assertThrows(IllegalArgumentException.class, () -> calculator.triangleArea(0, 1, 3), message);
        assertThrows(IllegalArgumentException.class, () -> calculator.triangleArea(1, -1, 3), message);
        assertThrows(IllegalArgumentException.class, () -> calculator.triangleArea(1, 3, -0.1), message);
    }

    @Test
    void testTriangleAreaMethod_ShouldThrowException_ifOneSideIsBiggerThenSumOfTheOthers(){
        String message = "Invalid triangle side length. Side length can't be bigger or equal to sum of the others";

        assertThrows(IllegalArgumentException.class, () -> calculator.triangleArea(10, 1, 3), message);
        assertThrows(IllegalArgumentException.class, () -> calculator.triangleArea(1, 10, 3), message);
        assertThrows(IllegalArgumentException.class, () -> calculator.triangleArea(1, 3, 10), message);
    }

    @Test
    void testTriangleAreaMethod_ShouldReturnCorrectAreaOfTriangle(){
        double actualOutput = calculator.triangleArea(10,11,13);
        double expectedOutput = 53.442;

        assertEquals(expectedOutput,actualOutput);
    }
}
