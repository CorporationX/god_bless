package faang.school.godbless.groupUsers.model;

import faang.school.godbless.reverse.Example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {
    @Test
    public void reverse_shouldReturnReversedArray() {
        var nums = new int[]{1, 2, 3, 4, 5};
        var expected = new int[]{5, 4, 3, 2, 1};
        var result = Example.reverse(nums);
        assertArrayEquals(expected, result);
    }
}
