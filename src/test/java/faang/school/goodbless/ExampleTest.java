package faang.school.goodbless;

import faang.school.godbless.Example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {
    private int[] nums;

    @BeforeEach
    public void setUp() {
        nums = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void reverseTest() {
        int[] result = Example.reverse(nums);

        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result);
    }
}
