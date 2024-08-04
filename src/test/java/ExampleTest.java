import faang.school.godbless.Example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {
    @Test
    public void testReverse1(){

        int[] nums = new int[]{1,2,3,4,5,6};
        int[] reversedNums = new int[]{6,5,4,3,2,1};
        int[] emptyArray = new int[]{};

        assertArrayEquals(reversedNums, Example.reverse1(nums));
        assertArrayEquals(emptyArray, Example.reverse1(emptyArray));
    }
    @Test
    public void testReverse2(){
        int[] nums = new int[]{1,2,3,4,5,6};
        int[] reversedNums = new int[]{6,5,4,3,2,1};
        int[] emptyArray = new int[]{};

        assertArrayEquals(reversedNums, Example.reverse2(nums));
        assertArrayEquals(emptyArray, Example.reverse2(emptyArray));
    }

}
