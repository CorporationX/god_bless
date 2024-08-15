package faang.school.godbless.sprint2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RememberSchoolTest {
    private RememberSchool triangle;

    @BeforeEach
    void setUp() {
        triangle = new RememberSchool();
    }

    @Test
    void isInvalidArgsWhen954() {
        double a = 9.0;
        double b = 5.0;
        double c = 4.0;
        assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(a, b, c));
    }

    @Test
    void isInvalidArgsWhen125() {
        double a = 1.0;
        double b = 2.0;
        double c = 5.0;
        assertThrows(IllegalArgumentException.class, () -> triangle.triangleArea(a, b, c));
    }

    @Test
    void triangleAreaWhen543Then6() {
        double a = 5.0;
        double b = 4.0;
        double c = 3.0;
        assertEquals(6.0, triangle.triangleArea(a, b, c));
    }

    @Test
    void triangleAreaWhen6108Then24() {
        double a = 6.0;
        double b = 10.0;
        double c = 8.0;
        assertEquals(24.0, triangle.triangleArea(a, b, c));
    }

    @Test
    void triangleAreaWhen212() {
        double a = 2.0;
        double b = 1.0;
        double c = 2.0;
        double result = Math.round(triangle.triangleArea(a, b, c) * 100.0) / 100.0;
        assertEquals(0.97, result);
    }
}