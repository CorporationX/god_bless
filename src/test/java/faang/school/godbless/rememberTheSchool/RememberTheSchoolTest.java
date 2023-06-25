package faang.school.godbless.rememberTheSchool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RememberTheSchoolTest {
    private RememberTheSchool rememberTheSchool;

    @BeforeEach
    void setUp() {
        rememberTheSchool = new RememberTheSchool();
    }

    @Test
    public void testCorrect() {
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;
        double result = rememberTheSchool.triangleArea(a, b, c);
        double expected = 6.0;

        assertEquals(expected, result);
    }

    @Test
    public void testNotExistedTriangle() {
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;

        assertThrows(IllegalArgumentException.class, () -> rememberTheSchool.triangleArea(a, b, c),
                "Треугольник с данными сторонами не существует!");
    }
}