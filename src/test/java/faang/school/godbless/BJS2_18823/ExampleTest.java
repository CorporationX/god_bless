package faang.school.godbless.BJS2_18823;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void reverseTest() {
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
        Example.reverse(nums);

        Integer[] expected = new Integer[]{7,6,5,4,3,2,1};

        assertEquals(0, Arrays.compare(expected, nums));
    }
}