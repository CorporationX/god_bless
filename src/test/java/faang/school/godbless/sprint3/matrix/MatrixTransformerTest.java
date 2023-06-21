package faang.school.godbless.sprint3.matrix;

import faang.school.godbless.sprint3.matrix.MatrixTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixTransformerTest {
    @ParameterizedTest
    @MethodSource("getParams")
    void flipMatrix_arraysShouldMatch(
            int[][] expectedMatrix,
            int[][] actualMatrix,
            MatrixTransformer.FlipDirection direction
    ) {
        expectedMatrix = MatrixTransformer.flipMatrix(expectedMatrix, direction);
        assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @Test
    void flipMatrix_shouldReturnEmptyMatrix() {
        int[][] expectedMatrix = new int[0][0];
        int[][] actualMatrix = MatrixTransformer.flipMatrix(new int[0][0], MatrixTransformer.FlipDirection.VERTICAL);
        assertArrayEquals(expectedMatrix, actualMatrix);
    }

    static Stream<Arguments> getParams() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] verticalRotatedMatrix = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        int[][] horizontalRotatedMatrix = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };

        return Stream.of(
                Arguments.of(
                        matrix,
                        verticalRotatedMatrix,
                        MatrixTransformer.FlipDirection.VERTICAL
                ),
                Arguments.of(
                        matrix,
                        horizontalRotatedMatrix,
                        MatrixTransformer.FlipDirection.HORIZONTAL
                )
        );
    }
}