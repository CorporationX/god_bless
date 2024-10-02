package turn_around;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    @Test
    void reverse() {
        Integer[] nums = {1, 2, 3, 4, 5};
        Example example = new Example();
        Integer[] result = example.reverse(nums);
        assertArrayEquals(new Integer[]{5, 4, 3, 2, 1}, result);
    }

}