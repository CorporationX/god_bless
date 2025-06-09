package school.faang.bjs2_80252_matrix_flip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private final int[][] matrix3x3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    private final int[][] matrix2x2 = {
            {1, 2},
            {3, 4},
    };

    private final int[][] matrix1x1 = {
            {1},
    };

    @Test
    void flipMatrixShouldFlip2x2MatrixVertically() {
        int[][] flipped = Matrix.flipMatrix(matrix2x2, FlipDirection.VERTICAL);
        assertEquals(2, flipped[0][0]);
        assertEquals(1, flipped[0][1]);
        assertEquals(4, flipped[1][0]);
        assertEquals(3, flipped[1][1]);
    }

    @Test
    void flipMatrixShouldFlip2x2MatrixHorizontally() {
        int[][] flipped = Matrix.flipMatrix(matrix2x2, FlipDirection.HORIZONTAL);
        assertEquals(3, flipped[0][0]);
        assertEquals(4, flipped[0][1]);
        assertEquals(1, flipped[1][0]);
        assertEquals(2, flipped[1][1]);
    }

    @Test
    void flipMatrixShouldFlip3x3MatrixVertically() {
        int[][] flipped = Matrix.flipMatrix(matrix3x3, FlipDirection.VERTICAL);
        assertEquals(3, flipped[0][0]);
        assertEquals(2, flipped[0][1]);
        assertEquals(1, flipped[0][2]);
    }

    @Test
    void flipMatrixShouldFlip3x3MatrixHorizontally() {
        int[][] flipped = Matrix.flipMatrix(matrix3x3, FlipDirection.HORIZONTAL);
        assertEquals(7, flipped[0][0]);
        assertEquals(8, flipped[0][1]);
        assertEquals(9, flipped[0][2]);
    }

    @Test
    void flipMatrixShouldReturnNullForNullMatrix() {
        int[][] flipped = Matrix.flipMatrix(null, FlipDirection.HORIZONTAL);
        assertNull(flipped);
    }

    @Test
    void flipMatrixShouldNotChange1x1Matrix() {
        int[][] flipped = Matrix.flipMatrix(matrix1x1, FlipDirection.HORIZONTAL);
        assertEquals(1, flipped[0][0]);
    }
}