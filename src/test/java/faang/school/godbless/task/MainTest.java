package faang.school.godbless.task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    @Test
    void testSumWithCorrectList() {
        int sum = Main.sum(List.of(1, 2, 3, 4));
        assertEquals(10, sum);
    }

    @Test
    void testSumWithEmptyList() {
        var exception = assertThrows(IllegalArgumentException.class, () -> Main.sum(new ArrayList<>()));
        assertEquals(Main.EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void testProductWithCorrectData() {
        int product = Main.product(List.of(1, 2, 3, 4));
        assertEquals(24, product);
    }

    @Test
    void testProductWithEmptyList() {
        var exception = assertThrows(IllegalArgumentException.class, () -> Main.product(new ArrayList<>()));
        assertEquals(Main.EXCEPTION_MESSAGE, exception.getMessage());
    }
}