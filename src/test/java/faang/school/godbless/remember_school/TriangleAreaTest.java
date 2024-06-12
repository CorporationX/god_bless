package faang.school.godbless.remember_school;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAreaTest {

    @ParameterizedTest
    @CsvSource({"4,3,5,6", "10,20,15,72.61843774138907", "7,8,9,26.832815729997478"})
    void triangleAreaTest(double a, double b, double c, double expected) {
        double result = TriangleArea.triangleArea(a, b, c);

        assertEquals(expected, result);
    }
}