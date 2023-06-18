package faang.school.godbless.sprint3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCalculateSumNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int actual = Main.sum(numbers);

        assertEquals(15, actual);
    }

    @Test
    void testCalculateProductNumbers() {
        List<Integer> numbers = List.of(1, 2, 3);

        int actual = Main.product(numbers);

        assertEquals(6, actual);
    }

    @Test
    void testCalculateNullList() {
        assertThrows(IllegalArgumentException.class, () -> Main.sum(null));
    }
}