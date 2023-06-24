package reverse_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static reverse_array.Example.reverse;

public class ExampleTest {

    @Test
    public void reverse_shouldReturnCorrectArray(){
        int[] nums = new int[]{1,2,3,4,5};
        reverse(nums);
        assertEquals(5, nums[0]);
        assertEquals(1, nums[4]);
    }
}
