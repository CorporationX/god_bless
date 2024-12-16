package school.faang.sprint_2.task_45660;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {

    @Test
    void testFlipMatrixHorizontal() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {2, 1},
                {4, 3}
        };
        int[][] result = MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);

        assertArrayEquals(expected, result);
    }

    @Test
    void testFlipMatrixVertical() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {3, 4},
                {1, 2}
        };
        int[][] result = MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL);

        assertArrayEquals(expected, result);
    }

    @Test
    void testTransformMatrixRotate() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        MatrixTransformer rotateTransformer = (x, y) -> new Coordinates(y, x);
        int[][] expected = {
                {1, 3},
                {2, 4}
        };
        int[][] result = MatrixUtils.transformMatrix(matrix, rotateTransformer);

        assertArrayEquals(expected, result);
    }

    @Test
    void testOriginalMatrixUnchanged() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] originalsCopy = {
                {1, 2},
                {3, 4}
        };

        MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(originalsCopy, matrix);
    }
}
