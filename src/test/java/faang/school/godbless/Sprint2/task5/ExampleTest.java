package faang.school.godbless.Sprint2.task5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    @Test
    void TestReverse() {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] reverseNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertArrayEquals(reverseNums, Example.reverse(nums));
    }
}