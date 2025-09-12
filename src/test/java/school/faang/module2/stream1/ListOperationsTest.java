package school.faang.module2.stream1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListOperationsTest {

    private final List<Integer> intList = List.of(1, 2, 3, 4, 5);
    private final List<String> strList = List.of("java", "swift", "jmeter", "metaverse");

    @Test
    void findSumOfEvenIntElementsTest() {
        Assertions.assertEquals(6, ListOperations.findSumOfEvenIntElements(intList));
    }

    @Test
    void findMaxOfIntElementsTest() {
        Assertions.assertEquals(5, ListOperations.findMaxOfIntElements(intList));
    }

    @Test
    void findAverageOfIntElementsTest() {
        Assertions.assertEquals(3.0, ListOperations.findAverageOfIntElements(intList));
    }

    @Test
    void countStringsStartingWithTest() {
        Assertions.assertEquals(2, ListOperations.countStringsStartingWith(strList, 'j'));
    }

    @Test
    void filterStringsContainingSubstring() {
        Assertions.assertEquals(
                List.of("jmeter", "metaverse"),
                ListOperations.filterStringsContainingSubstring(strList, "met")
        );
    }

    @Test
    void sortByLengthTest() {
        Assertions.assertEquals(
                List.of("java", "swift", "jmeter", "metaverse"),
                ListOperations.sortByLength(strList)
        );
    }

    @Test
    void getAllMatchConditionTest() {
        Assertions.assertTrue(ListOperations.getAllMatchCondition(intList, i -> i < 6));
        Assertions.assertTrue(ListOperations.getAllMatchCondition(intList, i -> i > 0));
        Assertions.assertFalse(ListOperations.getAllMatchCondition(intList, i -> i > 2));
    }

    @Test
    void findMinGreaterThanTest() {
        Assertions.assertEquals(3, ListOperations.findMinGreaterThan(intList, 2));
        Assertions.assertEquals(4, ListOperations.findMinGreaterThan(intList, 3));
    }

    @Test
    void convertToLengthsTest() {
        Assertions.assertEquals(
                List.of(4, 5, 6, 9),
                ListOperations.convertToLengths(strList)
        );
    }

}