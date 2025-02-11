package school.faang.task_59590;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProcessTest {

    @Test
    void testSumPositiveNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertEquals(15, Process.sum(numbers));
    }

    @Test
    void testProductPositiveNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertEquals(120, Process.product(numbers));
    }

    @Test
    void testSumEmptyList() {
        List<Integer> numbers = List.of();
        assertThrows(NoSuchElementException.class, () -> Process.sum(numbers));

    }

    @Test
    void testProductEmptyList() {
        List<Integer> numbers = List.of();
        assertThrows(NoSuchElementException.class, () -> Process.product(numbers));
    }

    @Test
    void testSumSingleElementList() {
        List<Integer> numbers = List.of(10);
        assertEquals(10, Process.sum(numbers));
    }

    @Test
    void testProductSingleElementList() {
        List<Integer> numbers = List.of(10);
        assertEquals(10, Process.product(numbers));
    }

    @Test
    void testSumNegativeNumbers() {
        List<Integer> numbers = List.of(-1, 2, -3, 4, -5);
        assertEquals(-3, Process.sum(numbers));
    }

    @Test
    void testProductNegativeNumbers() {
        List<Integer> numbers = List.of(-1, 2, -3, 4, -5);
        assertEquals(-120, Process.product(numbers));
    }

    @Test
    void testSumWithZero() {
        List<Integer> numbers = List.of(1, 0, 3, 4, 5);
        assertEquals(13, Process.sum(numbers));
    }

    @Test
    void testProductWithZero() {
        List<Integer> numbers = List.of(1, 0, 3, 4, 5);
        assertEquals(0, Process.product(numbers));
    }
}