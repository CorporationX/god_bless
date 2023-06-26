package faang.school.godbless.turnAroundMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixConverterTest {
    private int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
    };

    private int[][] expectedMatrixHorizontalFlip = {
            {4, 3, 2, 1},
            {8, 7, 6, 5},
            {12, 11, 10, 9}
    };

    private int[][] expectedMatrixVerticalFlip = {
            {9, 10, 11, 12},
            {5, 6, 7, 8},
            {1, 2, 3, 4}
    };

    @Test
    void testFlipMatrix() {
        assertAll(
                () -> assertArrayEquals(expectedMatrixHorizontalFlip,
                        MatrixConverter.flipMatrix(matrix, FlipDirection.HORIZONTAL)),
                () -> assertArrayEquals(expectedMatrixVerticalFlip,
                        MatrixConverter.flipMatrix(matrix, FlipDirection.VERTICAL))
        );
    }
}