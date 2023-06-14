package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExampleTest {

    Example example;

    @BeforeEach
    void setUp() {
        example = new Example();
    }

    @Test
    void testReverseNums() {
        int[] nums = {1, 2, 3, 4};
        int[] expectedNums = {4, 3, 2, 1};

        Assertions.assertArrayEquals(expectedNums, example.reverse(nums));
    }
}