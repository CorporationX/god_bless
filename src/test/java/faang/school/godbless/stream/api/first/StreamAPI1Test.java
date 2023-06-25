package faang.school.godbless.stream.api.first;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamAPI1Test {
    List<Integer> integerList;
    List<String> stringList;

    @BeforeEach
    void setUp() {
        integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        stringList = List.of("Before moving on",
                "let's take a look at some specific examples",
                "lambda expressions");
    }

    @Test
    void sum_CorrectAnswer() {
        int result = StreamAPI1.sum(integerList);
        assertEquals(result, 20);
    }

    @Test
    void max_CorrectAnswer() {
        int result = StreamAPI1.max(integerList);
        assertEquals(result, 9);
    }

    @Test
    void avg_CorrectAnswer() {
        double result = StreamAPI1.avg(integerList);
        assertEquals(result, 4.5);
    }

    @Test
    void numberOfLines_CorrectAnswer() {
        long result = StreamAPI1.numberOfLines(stringList, 'l');
        assertEquals(result, 2);
    }

    @Test
    void filter_CorrectAnswer() {
        List<String> result = StreamAPI1.filter(stringList, "on");
        List<String> expected = List.of("Before moving on",
                "lambda expressions");
        assertEquals(expected, result);
    }

    @Test
    void sorted_CorrectAnswer() {
        List<String> result = StreamAPI1.sorted(stringList);
        List<String> expected = List.of("Before moving on",
                "lambda expressions",
                "let's take a look at some specific examples");
        assertEquals(expected, result);
    }

    @Test
    void check_CorrectAnswer() {
        boolean result = StreamAPI1.check(integerList, s -> s > 0);
        assertFalse(result);
    }

    @Test
    void search_CorrectAnswer() {
        int result = StreamAPI1.search(integerList, 5);
        assertEquals(6, result);
    }

    @Test
    void transformation_CorrectAnswer() {
        List<Integer> result = StreamAPI1.transformation(stringList);
        List<Integer> expected = List.of(16, 43, 18);
        assertEquals(expected, result);
    }
}