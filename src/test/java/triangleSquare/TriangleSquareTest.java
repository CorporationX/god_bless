package triangleSquare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleSquareTest {
    @Test
    public void testCorrectCalculation() {
        int a = 5;
        int b = 3;
        int c = 4;

        double p = (a + b + c) / 2.0;
        double expectedSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        Square triangle = new Square();

        assertEquals(expectedSquare, triangle.triangleSquare(a, b, c));
    }
}
