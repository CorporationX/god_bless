import faang.school.godbless.practiceStreamAPI1.StreamAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamAPITest {
    List<Integer> numbers;
    List<String> strings;
    @BeforeEach
    public void init() {
        numbers = List.of(3, 6, 8, 9, 2);
        strings = List.of("Misha", "Madrid", "Iphone", "BMW", "hello");
    }

    @Test
    public void sumOfEvenNumbersTest() {
        int expected = 16;
        int test = StreamAPI.sumOfEvenNumbers(numbers);
        assertEquals(expected, test);
    }

    @Test
    public void findMaxValueTest() {
        int expected = 9;
        int test = StreamAPI.findMaxValue(numbers);
        assertEquals(expected, test);
    }

    @Test
    public void findMediumValue() {
        double expected = 5.6;
        double test = StreamAPI.findMediumValue(numbers);
        assertEquals(expected, test);
    }
    @Test
    public void findCountOfRows() {
        long expected = 1;
        long test = StreamAPI.findCountOfRows(strings);
        assertEquals(expected, test);
    }
}
