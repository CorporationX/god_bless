package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    @ParameterizedTest
    @MethodSource("fillArray")
    void testReverse(int[] expected, int[] nums) {
        Example.reverse(nums);
        assertArrayEquals(expected, nums);
    }

    @ParameterizedTest
    @MethodSource("fillArray")
    void testReverseToNewArray(int[] expected, int[] nums) {
        int[] result = Example.reverseToNewArray(nums);
        assertAll("Test equals array",
                () -> assertEquals(expected.length, result.length),
                () -> assertArrayEquals(expected, result)
        );
    }

    @Test
    void testNullInputData(){
        int[] nums = null;
        int[] expected = new int[]{};
        int[] result = Example.reverseToNewArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    void testVoidInputData(){
        int[] nums = new int[] {};
        int[] expected = new int[]{};
        int[] result = Example.reverseToNewArray(nums);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> fillArray() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{9, 8, 7, 6}, new int[]{6, 7, 8, 9})
        );
    }
}