package school.faang.rotate.the.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixConverterTest {
    private int[][] matrix;

    @BeforeEach
    public void setUp() {
        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
    }

    @Test
    void flipMatrixHorizontalTest() {
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };
        int[][] actual = MatrixConverter.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, actual);
    }

    @Test
    void flipMatrixVerticalTest() {
        int[][] expected = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        int[][] actual = MatrixConverter.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(expected, actual);
    }
}
