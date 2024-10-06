package bjs2_28998;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    @DisplayName("Test reverse on empty array")
    public void testEmptyArray() {
        // arrange
        int[] nums = {};
        int[] expectedResult = {};

        // act
        Example.reverse(nums);

        // assert
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    @DisplayName("Test reverse on one element array")
    public void testOneElementArray() {
        // arrange
        int[] nums = {5};
        int[] expectedResult = {5};

        // act
        Example.reverse(nums);

        // assert
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    @DisplayName("Test reverse on two element array")
    public void testTwoElementArray() {
        // arrange
        int[] nums = {3, 8};
        int[] expectedResult = {8, 3};

        // act
        Example.reverse(nums);

        // assert
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    @DisplayName("Test reverse on odd length array")
    public void testOddLengthArray() {
        // arrange
        int[] nums = {3, 8, 5, 7, 9};
        int[] expectedResult = {9, 7, 5, 8, 3};

        // act
        Example.reverse(nums);

        // assert
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    @DisplayName("Test reverse on even length array")
    public void testEvenLengthArray() {
        // arrange
        int[] nums = {5, 6, 7, 1, 2, 6};
        int[] expectedResult = {6, 2, 1, 7, 6, 5};

        // act
        Example.reverse(nums);

        // assert
        assertArrayEquals(expectedResult, nums);
    }
}
