package main.faang.school.godbless.rememberSchoolTest;

import faang.school.godbless.sprint2.rememberSchool.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    @Test
    public void testTriangleAreaReturnCorrect() {
        double result = Main.triangleArea(5, 10, 10);

        assertEquals(24.206145913796355, result);

    }

    @Test
    public void testTriangleAreaTrowException() {

        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(-1, 6, 10));
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(0, 6, 10));

    }
}