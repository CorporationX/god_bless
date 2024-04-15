package faang.school.godbless.remember_school;

import faang.school.godbless.sprint_2.remember_school.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void should_be_correct_1() {
        double result = Main.triangleArea(3, 4, 5);
        assertEquals(result, 6.0);
    }

    @Test
    void should_be_correct_2() {
        double result = Main.triangleArea(6, 8, 10);
        assertEquals(result, 24.0);
    }

    @Test()
    void should_throw_an_exception_1() {
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(1, 2, 3));
    }

    @Test
    void should_throw_an_exception_2() {
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(5, -1, 3));
    }
}