package faang.school.godbless.sprint2.task5;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @ParameterizedTest
    @MethodSource("getArrayParams")
    void reverse(int[] array, int[] expected) {
        new Example().reverse(array);
        assertArrayEquals(array, expected);
    }

    static Stream<Arguments> getArrayParams() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1}),
                Arguments.of(new int[] {99, 88, 77, 66, 55}, new int[] {55, 66, 77, 88, 99})
        );
    }
}