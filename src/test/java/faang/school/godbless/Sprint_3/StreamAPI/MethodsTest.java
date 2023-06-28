package faang.school.godbless.Sprint_3.StreamAPI;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {
    List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<String> strings = Arrays.asList("John", "Home", "Space", "Java", "Go");

    @Test
    public void sumEvenTest() {
        assertEquals(Methods.sumEven(nums), 20);
    }

    @Test
    public void maxElementTest() {
        assertEquals(Methods.maxElement(nums).getAsInt(), 9);
    }

    @Test
    public void averageTest() {
        assertEquals(Methods.average(nums).getAsDouble(), 4.5);
    }

    @Test
    public void startWithTest() {
        assertEquals(Methods.startWith(strings, 'J'), 2);
    }

    @Test
    public void sortStringByLengthTest() {
        assertEquals(Methods.sortStringByLength(strings).get(0), "Go");
    }

    @Test
    public void checkElementsTest() {
        assertEquals(Methods.checkElements(nums, num -> (int) num > 3), false);
    }

    @Test
    public void minAfterTest() {
        assertEquals(Methods.minAfter(nums, 8).getAsInt(), 9);
    }

    @Test
    public void stringsToLengthsTest() {
        assertEquals(Methods.stringsToLengths(strings).get(0), 4);
    }
}