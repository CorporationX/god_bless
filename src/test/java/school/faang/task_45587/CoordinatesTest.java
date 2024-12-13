package school.faang.task_45587;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void testSuccessVerticalTransformMatrix() {
        int[][] matrix1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] matrix2 = new int[][]{{1, 2}, {3, 4}};
        int[][] expectedMatrix1 = new int[][]{{5, 6}, {3, 4}, {1, 2}};
        int[][] expectedMatrix2 = new int[][]{{3, 4}, {1, 2}};

        assertArrayEquals(expectedMatrix1, Coordinates.flipMatrix(matrix1, FlipDirection.VERTICAL));
        assertArrayEquals(expectedMatrix2, Coordinates.flipMatrix(matrix2, FlipDirection.VERTICAL));
    }

    @Test
    void testSuccessHorizontalTransformMatrix() {
        int[][] matrix1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] matrix2 = new int[][]{{1, 2}, {3, 4}};
        int[][] expectedMatrix1 = new int[][]{{2, 1}, {4, 3}, {6, 5}};
        int[][] expectedMatrix2 = new int[][]{{2, 1}, {4, 3}};

        assertArrayEquals(expectedMatrix1, Coordinates.flipMatrix(matrix1, FlipDirection.HORIZONTAL));
        assertArrayEquals(expectedMatrix2, Coordinates.flipMatrix(matrix2, FlipDirection.HORIZONTAL));
    }

    @Test
    void testFlipMatrixWithEmptyInputParameters() {
        assertEquals(0, Coordinates.flipMatrix(new int[][]{{1}, {3, 4}, {5, 6}}, FlipDirection.HORIZONTAL).length);
        assertEquals(0, Coordinates.flipMatrix(new int[][]{{}, {}}, FlipDirection.HORIZONTAL).length);
        assertEquals(0, Coordinates.flipMatrix(new int[][]{}, FlipDirection.HORIZONTAL).length);
    }
}