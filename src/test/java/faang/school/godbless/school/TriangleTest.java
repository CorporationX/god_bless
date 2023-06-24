package faang.school.godbless.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();

    }

    @ParameterizedTest
    @CsvSource({"3.0, 2.0, 3.0", "15.1, 7.2, 13.1"})
    void triangleArea_CorrectAnswer(double a, double b, double c) {
        double result = triangle.triangleArea(a, b, c);
        double p = (a + b + c) / 2;
        double formulaHeron = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        //Округляем до 2-х знаков
        double scale = Math.pow(10, 2);
        double formulaHeronResult = Math.ceil(formulaHeron * scale) / scale;
        assertEquals(formulaHeronResult, result);
    }
}