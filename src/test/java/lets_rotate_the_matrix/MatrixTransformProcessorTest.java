package lets_rotate_the_matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTransformProcessorTest {
    private final int[][] MATRIX = {{1, 2}, {3, 4}};

    @Test
    void transformMatrix() {
        int[][] resultMatrixTransformed = MatrixTransformProcessor.transformMatrix(MATRIX, (idxRow, idxColumn) -> new Coordinates(idxColumn, idxRow));
        assertEquals(Arrays.deepToString(new int[][]{{1, 3}, {2, 4}}), Arrays.deepToString(resultMatrixTransformed));
    }

    @Test
    void flipMatrixVertical() {
        int[][] resultMatrixVertical = MatrixTransformProcessor.flipMatrix(MATRIX, FlipDirection.VERTICAL);
        assertEquals(Arrays.deepToString(new int[][]{{3, 4}, {1, 2}}), Arrays.deepToString(resultMatrixVertical));
    }

    @Test
    void flipMatrixHorizontal() {
        int[][] resultMatrixHorizontal = MatrixTransformProcessor.flipMatrix(MATRIX, FlipDirection.HORIZONTAL);
        assertEquals(Arrays.deepToString(new int[][]{{2, 1}, {4, 3}}), Arrays.deepToString(resultMatrixHorizontal));
    }
}