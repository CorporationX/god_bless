package faang.school.godbless.sprint2.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void productWhenListIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Main.product(new ArrayList<>()));
    }

    @Test
    void sumWhenListIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> Main.sum(new ArrayList<>()));
        String expected = "Список пуст";
        assertEquals(expected, ex.getMessage());
    }

    @Test
    void sumWhenListWithOneElement() {
        int expected = 2;
        int result = Main.sum(List.of(2));
        assertEquals(expected, result);
    }

    @Test
    void productWhenListWithOneElement() {
        int expected = 2;
        int result = Main.sum(List.of(2));
        assertEquals(expected, result);
    }

    @Test
    void sumWhenListOf123456789Then45() {
        int expected = 45;
        int result = Main.sum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertEquals(expected, result);
    }

    @Test
    void productWhenListOf123456789Then362880() {
        int expected = 362880;
        int result = Main.product(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertEquals(expected, result);
    }

    @Test
    void productWhenListOf1Then1() {
        int expected = 1;
        int result = Main.product(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(expected, result);
    }

    @Test
    void sumWhenListOf22Elements1Then22() {
        int expected = 22;
        int result = Main.sum(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(expected, result);
    }
}