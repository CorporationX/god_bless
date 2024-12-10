package school.faang.sprint_2.task_45578;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatrixHelperTest {
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    @Test
    void testFlipMatrixLines() {
        int[][] expectedValue = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };

        var actualValue = MatrixHelper.flipMatrixLines(matrix);

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    void testFlipMatrixLinesWithZeroMatrix() {
        int[][] zeroMatrix = new int[0][0];
        assertThrows(IllegalArgumentException.class, () -> MatrixHelper.flipMatrixLines(zeroMatrix));
    }

    @Test
    void testFlipMatrixColumns() {
        int[][] expectedValue = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };

        var actualValue = MatrixHelper.flipMatrixColumns(matrix);

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    void testFlipMatrixColumnsWithZeroMatrix() {
        int[][] zeroMatrix = new int[0][0];
        assertThrows(IllegalArgumentException.class, () -> MatrixHelper.flipMatrixColumns(zeroMatrix));
    }

    @Test
    void testFlipMatrixTransposition() {
        int[][] expectedValue = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        var actualValue = MatrixHelper.flipMatrixTransposition(matrix);

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    void testFlipMatrixTranspositionWithZeroMatrix() {
        int[][] zeroMatrix = new int[0][0];
        assertThrows(IllegalArgumentException.class, () -> MatrixHelper.flipMatrixTransposition(zeroMatrix));
    }
}
