package faang.school.godbless.javacore.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void reverse_shouldReverseIntArray_whenGetEvenSizeArray() {
        int[] expectedResult = {0,9,8,7,6,5,4,3,2,1};
        int[] testNums = {1,2,3,4,5,6,7,8,9,0};

        new Example().reverse(testNums);

        assertArrayEquals(expectedResult, testNums);
    }

    @Test
    void reverse_shouldReverseIntArray_whenGetOddSizeArray() {
        int[] expectedResult = {11,0,9,8,7,6,5,4,3,2,1};
        int[] testNums = {1,2,3,4,5,6,7,8,9,0,11};

        new Example().reverse(testNums);

        assertArrayEquals(expectedResult, testNums);
    }

    @Test
    void reverse_shouldDoNothing_whenGetEmptyArray() {
        int[] testNums = {};
        int[] expectedResult = {};

        new Example().reverse(testNums);

        assertArrayEquals(expectedResult, testNums);
    }

    @Test
    void reverse_shouldLeaveArrayWithoutChanges_whenUseMethodTwice() {
        int[] testNums = {1,2,3,4,5,6,7,8,9,0,11};
        int[] expectedResult = {1,2,3,4,5,6,7,8,9,0,11};

        new Example().reverse(testNums);
        new Example().reverse(testNums);

        assertArrayEquals(expectedResult, testNums);
    }


}