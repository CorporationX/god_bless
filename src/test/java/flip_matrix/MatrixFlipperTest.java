package flip_matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MatrixFlipperTest {
    @Test
    public void testFlipMatrixHorizontal() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };

        int[][] result = MatrixFlipper.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlipMatrixVertical() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };

        int[][] result = MatrixFlipper.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlipMatrixEmptyMatrix() {
        int[][] matrix = {};

        int[][] expected = {};

        int[][] result = MatrixFlipper.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, result);
    }
}
