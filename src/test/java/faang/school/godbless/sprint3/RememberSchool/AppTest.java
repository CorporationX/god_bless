package faang.school.godbless.sprint3.RememberSchool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class AppTest {

    @ParameterizedTest
    @DisplayName("Тест с верным треугольником")
    @MethodSource("getCorrectTriangle")
    void triangleArea_TestWithCorrectTriangle(double expected, double a, double b, double c) {
        double result = App.triangleArea(a, b, c);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест с несуществующим треугольником")
    void triangle_TestWithUnrealTriangle() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> App.triangleArea(1, 2, 10));
        Assertions.assertEquals("Треугольник не может существовать", exception.getMessage());
    }

    private static Stream<Arguments> getCorrectTriangle() {
        List<Arguments> argumentsList = List.of(
                Arguments.of(6, 3, 4, 5),
                Arguments.of(12, 8, 5, 5)
        );
        return argumentsList.stream();
    }
}