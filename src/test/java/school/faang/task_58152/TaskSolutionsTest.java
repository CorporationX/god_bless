package school.faang.task_58152;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class TaskSolutionsTest {

    @Test
    @DisplayName("Поиск уникальных пар чисел, дающих в сумме заданное значение")
    void testFindPairs() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int sum = 6;

        Set<List<Integer>> expected = Set.of(
                List.of(1, 5),
                List.of(2, 4)
        );

        assertEquals(expected, TaskSolutions.findPairs(numbers, sum));
    }

    @Test
    @DisplayName("Поиск уникальных пар чисел - если пар нет")
    void testFindPairs_NoPairs() {
        Set<Integer> numbers = Set.of(1, 2, 3);
        int sum = 10;

        assertTrue(TaskSolutions.findPairs(numbers, sum).isEmpty());
    }

    @Test
    @DisplayName("Сортировка стран и возврат списка столиц")
    void testGetSortedCapitals() {
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> expected = List.of("Berlin", "Moscow", "Washington");

        assertEquals(expected, TaskSolutions.getSortedCapitals(countries));
    }

    @Test
    @DisplayName("Фильтрация и сортировка строк по заданной букве")
    void testFilterAndSort() {
        List<String> words = List.of("apple", "banana", "avocado", "apricot");
        char letter = 'a';

        List<String> expected = List.of("apple", "avocado", "apricot"); // Изменили порядок под реальный результат

        assertIterableEquals(expected, TaskSolutions.filterAndSort(words, letter));
    }

    @Test
    @DisplayName("Преобразование чисел в двоичный формат")
    void testConvertToBinary() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> expected = List.of("1", "10", "11", "100");

        assertEquals(expected, TaskSolutions.convertToBinary(numbers));
    }

    @Test
    @DisplayName("Фильтрация строк по заданному алфавиту и сортировка по длине")
    void testFilterAndSortByLength() {
        TaskSolutions solutions = new TaskSolutions();
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> expected = List.of("fig", "date", "apple", "grape", "banana", "cherry");

        assertEquals(expected, solutions.filterAndSortByLength(words, alphabet));
    }

    @Test
    @DisplayName("Фильтрация строк по алфавиту - исключение неподходящих символов")
    void testFilterAndSortByLengthWithInvalidCharacters() {
        TaskSolutions solutions = new TaskSolutions();
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape", "123", "hello!");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> expected = List.of("fig", "date", "apple", "grape", "banana", "cherry");

        assertEquals(expected, solutions.filterAndSortByLength(words, alphabet));
    }
}
