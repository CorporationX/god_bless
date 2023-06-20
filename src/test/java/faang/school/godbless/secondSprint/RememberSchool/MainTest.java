package faang.school.godbless.secondSprint.RememberSchool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testTriangleAreaReturnCorrectResult() {
        double result1 = Main.triangleArea(3, 4, 5);
        double result2 = Main.triangleArea(5, 3, 4);
        double result3 = Main.triangleArea(26, 28, 30);

        assertEquals(6, result1);
        assertEquals(6, result2);
        assertEquals(336, result3);
    }

    @Test
    public void testTriangleAreaThrowExc() {
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(0, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(1, -2, 3));
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(1, 2, 0));
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(3, 2, 1));
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(5, 8, 2));
    }
}