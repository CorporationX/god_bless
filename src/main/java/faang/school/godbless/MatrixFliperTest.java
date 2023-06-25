package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFliperTest {
    int[][] matrix;

    @BeforeEach
    public void onSet() {
        matrix = new int[][]{
                {1, 2},
                {3, 4}
        };
    }

    @Test
    public void testTransformMatrix() {
        MatrixTransformer transformer = (x, y) -> new Coordinates(y, x);
        int[][] transformedMatrix = MatrixFliper.transformMatrix(matrix, transformer);
        int[][] expectedMatrix = {
                {1, 3},
                {2, 4}
        };
        assertArrayEquals(expectedMatrix, transformedMatrix);
    }

    @Test
    public void testFlipMatrixHorizontal() {
        MatrixFliper.FlipDirection flipDirection = MatrixFliper.FlipDirection.HORIZONTAL;
        int[][] flippedMatrix = MatrixFliper.flipMatrix(matrix, flipDirection);
        int[][] expectedMatrix = {
                {2, 1},
                {4, 3}
        };
        assertArrayEquals(expectedMatrix, flippedMatrix);
    }

    @Test
    public void testFlipMatrixVertical() {
        MatrixFliper.FlipDirection flipDirection = MatrixFliper.FlipDirection.VERTICAL;
        int[][] flippedMatrix = MatrixFliper.flipMatrix(matrix, flipDirection);
        int[][] expectedMatrix = {
                {3, 4},
                {1, 2}
        };
        assertArrayEquals(expectedMatrix, flippedMatrix);
    }
}