package turn_around;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    @Test
    void reverse() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Example example = new Example();
        List<Integer> result = example.reverse(nums);
        assertEquals(List.of(5, 4, 3, 2, 1), result);
    }

}