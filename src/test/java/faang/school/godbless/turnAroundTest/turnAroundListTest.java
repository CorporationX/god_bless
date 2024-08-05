package faang.school.godbless.turnAroundTest;

import faang.school.godbless.turnAround.turnAround;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class turnAroundListTest {
    private turnAround numslist;

    @BeforeEach
    public void setUp(){
        numslist = new turnAround();

    }

    @Test
    public void testReverseOddLengthArray() {
        int[] nums = {1, 2, 3, 4, 5};

        numslist.reverse(nums);

        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testReverseSingleElementArray() {
        int[] nums = {1};

        numslist.reverse(nums);

        int[] expected = {1};
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testReverseEmptyArray() {
        int[] nums = {};

        numslist.reverse(nums);

        int[] expected = {};
        assertArrayEquals(expected, nums);
    }
}
