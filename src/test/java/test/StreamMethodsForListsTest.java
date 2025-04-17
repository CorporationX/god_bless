package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_70715.StreamMethodsfForLists;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamMethodsForListsTest {
    private List<Integer> integers;
    private List<String> strings;

    @BeforeEach
    public void setUp() {
        integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        strings = List.of(
                "Roga&Kopyta",
                "NNandPartners",
                "Horus&Co",
                "Emperor&Sons",
                "Granddad's Waste Processing Ltd.",
                "Tzeetnch's Library Foundation"
        );
    }

    @Test
    void testFindEvenSum() {
        int result = StreamMethodsfForLists.findEvenSum(integers);
        assertEquals(30, result);
    }

    @Test
    void testFindMax() {
        int result = StreamMethodsfForLists.findMax(integers);
        assertEquals(10, result);
    }

    @Test
    void testFindAverage() {
        double result = StreamMethodsfForLists.findAverage(integers);
        assertEquals(5.5, result);
    }

    @Test
    void testFindStringsStartingWith() {
        int result = StreamMethodsfForLists.findStringsStartingWith(strings, 'G');
        assertEquals(1, result);
    }

    @Test
    void testListContainsSubstring() {
        List<String> result = StreamMethodsfForLists.listContainsSubstring(strings, "&");
        assertEquals(3, result.size());
        assertTrue(result.contains("Roga&Kopyta"));
    }

    @Test
    void testConditionCheck() {
        boolean allEven = StreamMethodsfForLists.conditionCheck(integers, x -> x % 2 == 0);
        assertFalse(allEven);

        boolean allPositive = StreamMethodsfForLists.conditionCheck(integers, x -> x > 0);
        assertTrue(allPositive);
    }

    @Test
    void testFindMinBiggerThanGiven() {
        int result = StreamMethodsfForLists.findMinBiggerThanGiven(integers, 5);
        assertEquals(6, result);
    }

    @Test
    void testFindMinBiggerThanGivenThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            StreamMethodsfForLists.findMinBiggerThanGiven(integers, 100);
        });
    }

    @Test
    void testTransformToListOfLenghts() {
        for(String s: strings) {
            System.out.println(s.length());
        }
        List<Integer> result = StreamMethodsfForLists.transformToListOfLenghts(strings);
        System.out.println(result.toString());;
        List<Integer> expected = List.of(11, 13, 8, 12, 32, 29);
        assertEquals(expected, result);
    }
}