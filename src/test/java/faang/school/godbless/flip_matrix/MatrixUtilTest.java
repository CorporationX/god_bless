package faang.school.godbless.flip_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilTest {
    @Test
    public void testTransformMatrixIdentity() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] result = MatrixUtil.transformMatrix(matrix, coordinates -> new Coordinates(coordinates.x(), coordinates.y()));

        assertArrayEquals(matrix, result);
    }

    @Test
    public void testFlipMatrixHorizontal() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {2, 1},
                {4, 3}
        };

        int[][] result = MatrixUtil.flipMatrix(matrix, FlipDirection.HORIZONTAL);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlipMatrixVertical() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {3, 4},
                {1, 2}
        };

        int[][] result = MatrixUtil.flipMatrix(matrix, FlipDirection.VERTICAL);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlipMatrixHorizontal3x3() {
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

        int[][] result = MatrixUtil.flipMatrix(matrix, FlipDirection.HORIZONTAL);

        assertArrayEquals(expected, result);
    }
}