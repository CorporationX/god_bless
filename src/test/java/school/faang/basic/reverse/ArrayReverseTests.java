package school.faang.basic.reverse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayReverseTests {

    private static Stream<Arguments> provideArraysForReverse() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0, 1}, new int[]{1, 0}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1}),
                Arguments.of(new int[]{0, 1, 2, 3}, new int[]{3, 2, 1, 0}),
                Arguments.of(new int[]{0, 4, 1, 5, 2, 3, 2, 3}, new int[]{3, 2, 3, 2, 5, 1, 4, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForReverse")
    public void reversArrayTest(int[] input, int[] expectedOutput) {
        Assertions.assertThat(Example.reverse(input)).as("reverse array").isEqualTo(expectedOutput);
    }
}