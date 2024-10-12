import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.streams.streamApi1.ListOperations;

import java.util.Arrays;
import java.util.List;

public class ListOperationsTest {

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        Assertions.assertEquals(12, ListOperations.sumOfEvenNumbers(numbers));
        Assertions.assertEquals(6, ListOperations.findMax(numbers));
        Assertions.assertEquals(3.5, ListOperations.findAverage(numbers));
        Assertions.assertEquals(1, ListOperations.countStringsStartingWith(strings, 'a'));
        Assertions.assertEquals(List.of("banana"), ListOperations.filterStringsContainingSubstring(strings, "an"));
        Assertions.assertEquals(List.of("date", "apple", "banana", "cherry"), ListOperations.sortByLength(strings));
        Assertions.assertFalse(ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        Assertions.assertEquals(5, ListOperations.findMinGreaterThan(numbers, 4));
        Assertions.assertEquals(List.of(5, 6, 6, 4), ListOperations.convertToLengths(strings));
    }
}
