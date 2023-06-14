package task5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask5 {
    @Test
    void testCorrectReverse() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> actual = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
        assertEquals(Example.reverse(input), actual);
    }
}
