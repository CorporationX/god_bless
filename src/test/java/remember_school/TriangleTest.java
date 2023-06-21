package remember_school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void testValidTriangle() {
        Triangle triangle = new Triangle();
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;

        double actualArea = triangle.triangleArea(a, b, c);

        double expectedArea = 6.0;
        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    public void testInvalidTriangle() {
        Triangle triangle = new Triangle();
        double a = 1.0;
        double b = 2.0;
        double c = 10.0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(a, b, c));
    }

    @Test
    public void testNegativeSide() {
        Triangle triangle = new Triangle();
        double a = 3.0;
        double b = -4.0;
        double c = 5.0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(a, b, c));
    }
}
