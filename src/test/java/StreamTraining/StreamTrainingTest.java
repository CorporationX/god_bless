package StreamTraining;

import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.StreamTraining.StreamTraining.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTrainingTest {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    List<String> stringList = List.of("Jonathan", "Jon", "Jenna", "Debra", "William");

    @Test
    void evenSumTest() {
        int num = evenSum(integerList);

        assertEquals(20, num);
    }

    @Test
    void maxElementTest() {
        int num = maxElement(integerList);

        assertEquals(8, num);
    }

    @Test
    void averageValueTest() {
        double num = averageValue(integerList);

        assertEquals(4.5, num);
    }

    @Test
    void stringCountTest() {
        long num = stringCount(stringList, 'J');

        assertEquals(3, num);
    }

    @Test
    void substringContainsTest() {
        List<String> result = substringContains(stringList, "Jon");

        assertEquals(2, result.size());
    }

    @Test
    void sortByLengthTest() {
        List<String> result = sortByLength(stringList);

        assertEquals("Jon", result.get(0));
        assertEquals("Jonathan", result.get(result.size() - 1));
    }

    @Test
    void checkTheListTest() {
        List<String> result = checkTheList(stringList, (e) -> e.length() > 5);

        assertEquals(2, result.size());
    }

    @Test
    void lessMoreThenTest() {
        int result = lessMoreThen(integerList, 4);

        assertEquals(5, result);
    }

    @Test
    void stringToLengthTest() {
        List<Integer> result = stringToLength(stringList);

        assertEquals(List.of(8, 3, 5, 5, 7), result);
    }
}
