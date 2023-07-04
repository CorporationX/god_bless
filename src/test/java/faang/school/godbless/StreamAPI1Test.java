package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamAPI1Test {
    StreamAPI1 taskManager;
    List<Integer> numbers;
    List<String> rows;

    @BeforeEach
    void setUp() {
        taskManager = new StreamAPI1();
        numbers = Arrays.asList(1, 2, 3, 4);
        rows = Arrays.asList("Alex", "Bob", "Matthew");
    }

    @Test
    void testFindSum() {
        var answer = taskManager.findSum(numbers);
        assertEquals(answer, 10);
    }

    @Test
    void testFindMax() {
        var answer = taskManager.findMax(numbers).get();
        assertEquals(answer, 4);
    }

    @Test
    void testFindAverage3() {
        var answer = taskManager.findAverage(numbers).getAsDouble();
        assertEquals(answer, 2.5, 1);
    }

    @Test
    void testCountRows() {
        var answer = taskManager.countRows(rows, 'A');
        assertEquals(answer, 1);
    }

    @Test
    void testContainsSubRow() {
        List<String> answer = taskManager.filterContainsSubRow(rows, "e");
        assertEquals(answer.size(), 2);
    }

    @Test
    void testSortByLength() {
        List<String> answer = taskManager.sortRowsByLength(rows);
        List<String> expectedResult = Arrays.asList("Matthew", "Alex", "Bob");
        assertEquals(answer, expectedResult);
    }

    @Test
    void testAllMatch() {
        boolean answer = taskManager.allMatch(numbers, (number) -> number > 0);
        assertTrue(answer);
    }

    @Test
    void testFindMinWithCheck() {
        var answer = taskManager.minWithCheck(numbers, 3);
        assertEquals(answer.get(), 4);
    }

    @Test
    void testRowsToLength() {
        var answer = taskManager.rowsToLength(rows);
        assertEquals(answer, Arrays.asList(4, 3, 7));
    }

}