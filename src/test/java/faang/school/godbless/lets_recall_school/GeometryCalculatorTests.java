package faang.school.godbless.lets_recall_school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeometryCalculatorTests {

    GeometryCalculator geometryCalculator = new GeometryCalculator();

    @Test
    @DisplayName("Calculates triangle area")
    void shouldCalculateTriangleArea() {

        double sideA = 3.0;
        double sideB = 4.0;
        double sideC = 5.0;

        double p = (sideA + sideB + sideC) / 2;

        double expectedArea = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));

        Assertions.assertEquals(expectedArea, geometryCalculator.triangleArea(sideA, sideB, sideC));
    }
}
