import faang.school.godbless.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {

    @Test
    @DisplayName("Валидные значения 5 6 7")
    void triangleAreaTest_validTriangle() {
        double a = 5;
        double b = 6;
        double c = 7;

        double result = Main.triangleArea(a, b, c);
        assertEquals(14.696938456699069, result);
    }

    @Test
    @DisplayName("Валидные значения 11 15 17")
    void triangleAreaTest_validTriangle2() {
        double a = 11;
        double b = 15;
        double c = 17;

        double result = Main.triangleArea(a, b, c);
        assertEquals(81.25999938469111, result);
    }

    @Test
    @DisplayName("несуществующий треугольник 1 20 15")
    void triangleAreaTest_invalidTriangle() {
        double a = 1;
        double b = 20;
        double c = 15;

        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(a, b, c));
    }

    @Test
    @DisplayName("Отрицательные стороны")
    void triangleAreaTest_negativeSide() {
        double a = -1;
        double b = 3;
        double c = 4;

        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(a, b, c));
    }
}
