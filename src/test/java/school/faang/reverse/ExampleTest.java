package school.faang.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static school.faang.reverse.Example.reverse;

public class ExampleTest {

    @Test
    public void testReverse() {
//        odd number of elements in the array
        int[] nums = {1, 2, 3, 4, 5};
        int[] numsReversed = {5, 4, 3, 2, 1};
        reverse(nums);
        assertArrayEquals(numsReversed, nums);

//        even number of elements in the array
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        int[] numsReversed2 = {6, 5, 4, 3, 2, 1};
        reverse(nums2);
        assertArrayEquals(numsReversed2, nums2);
    }

    @Test
    public void testReverseEmptyArray() {
        int[] nums = {};
        int[] numsReversed = {};
        reverse(nums);
        assertArrayEquals(numsReversed, nums);
    }

    @Test
    public void testReverseSingleElement() {
//        odd number of elements in the array
        int[] nums = {1};
        int[] numsReversed = {1};
        reverse(nums);
        assertArrayEquals(numsReversed, nums);
    }
}
