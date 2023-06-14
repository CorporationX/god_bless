package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @Test
    void revertTest(){
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        Example.reverse(nums);

        assertTrue(Arrays.equals(expected, nums));
    }

    @Test
    void nullArrayTest(){
        int[] nums = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Example.reverse(nums));
        String expected = "An array can't be empty";

        assertEquals(expected, exception.getMessage());
    }
}
