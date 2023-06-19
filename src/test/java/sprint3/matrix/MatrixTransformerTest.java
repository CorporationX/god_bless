package sprint3.matrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
        int [][] matrix1 = getMatrix(3, 3);
        int [][] matrix2 = getMatrix(5, 5);
        return Stream.of(
                Arguments.of(
                        matrix1,
                        getRotatedMatrix(matrix1, MatrixTransformer.FlipDirection.VERTICAL),
                        MatrixTransformer.FlipDirection.VERTICAL
                ),
                Arguments.of(
                        matrix2,
                        getRotatedMatrix(matrix2, MatrixTransformer.FlipDirection.HORIZONTAL),
                        MatrixTransformer.FlipDirection.HORIZONTAL
                )
        );
    }

    static int[][] getMatrix(int x, int y) {
        int[][] matrix = new int[x][y];
        int count = 1;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[i][j] = count++;
            }
        }
        return matrix;
    }

    static int[][] getRotatedMatrix(int[][] matrix, MatrixTransformer.FlipDirection direction) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < rotatedMatrix.length; ++i) {
            for (int j = 0; j < rotatedMatrix[0].length; ++j) {
                if (direction == MatrixTransformer.FlipDirection.VERTICAL) {
                    rotatedMatrix[i][j] = matrix[matrix.length - 1 - i][j];
                } else {
                    rotatedMatrix[i][j] = matrix[i][matrix.length - 1 - j];
                }
            }
        }
        return rotatedMatrix;
    }
}