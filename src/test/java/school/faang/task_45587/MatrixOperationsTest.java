package school.faang.task_45587;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOperationsTest {

    @Test
    void testSuccessVerticalTransformMatrix() {
        int[][] matrix1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] expectedMatrix1 = new int[][]{{5, 6}, {3, 4}, {1, 2}};
        assertArrayEquals(expectedMatrix1, MatrixOperations.flipMatrix(matrix1, FlipDirection.VERTICAL));

        int[][] expectedMatrix2 = new int[][]{{3, 4}, {1, 2}};
        int[][] matrix2 = new int[][]{{1, 2}, {3, 4}};
        assertArrayEquals(expectedMatrix2, MatrixOperations.flipMatrix(matrix2, FlipDirection.VERTICAL));

        int[][] matrix3 = new int[][]{{1}, {3}};
        int[][] expectedMatrix3 = new int[][]{{3}, {1}};
        assertArrayEquals(expectedMatrix3, MatrixOperations.flipMatrix(matrix3, FlipDirection.VERTICAL));

        int[][] matrix4 = new int[][]{{1}};
        int[][] expectedMatrix4 = new int[][]{{1}};
        assertArrayEquals(expectedMatrix4, MatrixOperations.flipMatrix(matrix4, FlipDirection.VERTICAL));
    }

    @Test
    void testSuccessHorizontalTransformMatrix() {
        int[][] matrix1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] expectedMatrix1 = new int[][]{{2, 1}, {4, 3}, {6, 5}};
        assertArrayEquals(expectedMatrix1, MatrixOperations.flipMatrix(matrix1, FlipDirection.HORIZONTAL));


        int[][] matrix2 = new int[][]{{1, 2}, {3, 4}};
        int[][] expectedMatrix2 = new int[][]{{2, 1}, {4, 3}};
        assertArrayEquals(expectedMatrix2, MatrixOperations.flipMatrix(matrix2, FlipDirection.HORIZONTAL));

        int[][] matrix3 = new int[][]{{1}, {3}};
        int[][] expectedMatrix3 = new int[][]{{1}, {3}};
        assertArrayEquals(expectedMatrix3, MatrixOperations.flipMatrix(matrix3, FlipDirection.HORIZONTAL));

        int[][] matrix4 = new int[][]{{1}};
        int[][] expectedMatrix4 = new int[][]{{1}};
        assertArrayEquals(expectedMatrix4, MatrixOperations.flipMatrix(matrix4, FlipDirection.HORIZONTAL));
    }

    @Test
    void testFlipMatrixWithInvalidInputParameters() {
        assertEquals(0,
                MatrixOperations.flipMatrix(new int[][]{{1}, {3, 4}, {5, 6}}, FlipDirection.HORIZONTAL).length);
        assertEquals(0, MatrixOperations.flipMatrix(new int[][]{{}, {}}, FlipDirection.HORIZONTAL).length);
        assertEquals(0, MatrixOperations.flipMatrix(new int[][]{}, FlipDirection.HORIZONTAL).length);
        assertEquals(0, MatrixOperations.flipMatrix(new int[][]{{1}, {2}, {3}}, null).length);
    }
}