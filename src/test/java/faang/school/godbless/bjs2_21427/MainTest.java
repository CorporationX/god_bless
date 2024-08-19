package faang.school.godbless.bjs2_21427;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    @Test
    void testProduct() {
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> Main.sum(null));
        assertEquals("List of numbers cannot be null", nullException.getMessage());

        Exception emptyException = assertThrows(IllegalArgumentException.class, () -> Main.sum(List.of()));
        assertEquals("List of numbers cannot be empty", emptyException.getMessage());

        var result0 = Main.product(List.of(1));
        assertEquals(1, result0);

        var result1 = Main.product(List.of(1, 2));
        assertEquals(2, result1);

        var result2 = Main.product(List.of(1, 2, 3));
        assertEquals(6, result2);
    }

    @Test
    void testSum() {
        Exception nullException = assertThrows(IllegalArgumentException.class, () -> Main.sum(null));
        assertEquals("List of numbers cannot be null", nullException.getMessage());

        Exception emptyException = assertThrows(IllegalArgumentException.class, () -> Main.sum(List.of()));
        assertEquals("List of numbers cannot be empty", emptyException.getMessage());

        var result0 = Main.sum(List.of(1));
        assertEquals(1, result0);

        var result1 = Main.sum(List.of(1, 2));
        assertEquals(3, result1);

        var result2 = Main.sum(List.of(1, 2, 3));
        assertEquals(6, result2);
    }
}