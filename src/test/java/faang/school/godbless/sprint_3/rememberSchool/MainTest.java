package faang.school.godbless.sprint_3.rememberSchool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    public void init() {
        main = new Main();
    }

    @Test
    public void triangleAreaTest() {
        double a = 10;
        double b = 15;
        double c = 15;

        Double expected = 70.71067811865476;
        Double result = main.triangleArea(a, b, c);

        assertEquals(expected, result);
        assertThrows(IllegalArgumentException.class, () -> main.triangleArea(5, 2, 15));
    }
}