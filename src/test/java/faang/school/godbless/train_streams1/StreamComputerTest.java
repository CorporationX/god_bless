package faang.school.godbless.train_streams1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static faang.school.godbless.train_streams1.StreamComputer.*;

public class StreamComputerTest {

    @Test
    public void testSumEvens() {
        assertEquals(30, sumOfEvens(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertEquals(0, sumOfEvens(List.of(1, 3, 5)));
    }

    @Test
    public void testMax() {
        assertEquals(5, max(List.of(1, 2, 3, 4, 5)));
        assertEquals(-1, max(List.of()));
    }

    @Test
    public void testAvg() {
        assertEquals(3.0, avg(List.of(1, 2, 3, 4, 5)));
        assertEquals(0.0, avg(List.of()));
    }

    @Test
    public void testCountStartingWith() {
        assertEquals(4, countStartingWith(List.of("the", "therapist", "therefore", "them", "table"), "the"));
        assertEquals(0, countStartingWith(List.of(), ""));
    }

    @Test
    public void testFilterContainingSubstring() {
        assertEquals(List.of("numeric", "numbers", "nums"),
                filterContainingSubstring(List.of("numeric", "numbers", "nums"), "num"));
        assertEquals(List.of(), filterContainingSubstring(List.of("street", "city", "country"), "county"));
    }

    @Test
    public void testSortByLength() {
        assertEquals(List.of("city", "street", "country"),
                sortByLength(List.of("country", "city", "street"), (s1, s2) -> s1.length() - s2.length()));
        assertEquals(List.of("country", "street", "city"),
                sortByLength(List.of("country", "city", "street"), (s1, s2) -> s2.length() - s1.length()));
    }

    @Test
    public void testAllMatchCondition() {
        assertFalse(allMatchCondition(List.of("list", "textbook", "blank", "examination", "sheet"), s -> s.length() <= 5));
        assertTrue(allMatchCondition(List.of("string", "starter", "sensation"), s -> s.startsWith("s")));
    }

    @Test
    public void testMinGreaterThanTarget() {
        assertEquals(3, minGreaterThanTarget(List.of(1, 2, 3, 4, 5), 2));
        assertEquals(-1, minGreaterThanTarget(List.of(2, 4, 6, 8, 10), 10));
    }

    @Test
    public void testMapToLength() {
        assertEquals(List.of(1, 3, 5), mapToLength(List.of("a", "the", "apple")));
        assertEquals(List.of(), mapToLength(List.of()));
    }
}
