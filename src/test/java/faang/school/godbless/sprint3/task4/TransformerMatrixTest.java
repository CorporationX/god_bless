package faang.school.godbless.sprint3.task4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TransformerMatrixTest {

    @ParameterizedTest
    @MethodSource("arrayProviderHorizontal")
    void testFlipMatrixHorizontal(int[][] matrix, int[][] expected) {
        int[][] actual = TransformerMatrix.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("arrayProviderVertical")
    void testFlipMatrixVertical(int[][] matrix, int[][] expectedVertical) {
        int[][] actual = TransformerMatrix.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expectedVertical, actual);
    }

    @Test
    void testValidationArray() {
        int[][] arr = {{},{}};
        assertThrows(IllegalArgumentException.class, () -> TransformerMatrix.flipMatrix(null, FlipDirection.HORIZONTAL));
        assertThrows(IllegalArgumentException.class, () -> TransformerMatrix.flipMatrix(arr, FlipDirection.HORIZONTAL));
    }

    @ParameterizedTest
    @MethodSource("arrayProviderVertical")
    void testValidationFlipDirection(int[][] expected) {
        assertThrows(IllegalArgumentException.class, () -> TransformerMatrix.flipMatrix(expected, null));
    }

    static Stream<Arguments> arrayProviderHorizontal() {
        int[][] expected = {
                {7, 6, 5, 4, 3, 2, 1},
                {8, 7, 6, 5, 4, 3, 2},
                {3, 2, 0, 3, 4, 3, 3},
        };

        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7},
                {2, 3, 4, 5, 6, 7, 8},
                {3, 3, 4, 3, 0, 2, 3},
        };
        return Stream.of(
                Arguments.of(matrix, expected)
        );
    }

    static Stream<Arguments> arrayProviderVertical() {
        int[][] expected = {
                {3, 3, 4, 3, 0, 2, 3},
                {2, 3, 4, 5, 6, 7, 8},
                {1, 2, 3, 4, 5, 6, 7},
        };

        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7},
                {2, 3, 4, 5, 6, 7, 8},
                {3, 3, 4, 3, 0, 2, 3},
        };
        return Stream.of(
                Arguments.of(matrix, expected)
        );
    }
}