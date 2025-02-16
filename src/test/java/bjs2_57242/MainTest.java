package bjs2_57242;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void flipMatrixFailedOnNullMatrix() {
        // Arrange
        int[][] matrix = null;

        // Act + Assert
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Main.flipMatrix(matrix, FlipDirection.HORIZONTAL));
    }

    @Test
    void flipMatrix2x2Vertical() {
        // Arrange
        int[][] matrix = { {1, 2}, {3, 4} };
        int[][] expectedResult = { {3, 4}, {1, 2} };

        runTest(matrix, expectedResult, FlipDirection.VERTICAL);
    }

    @Test
    void flipMatrix2x2Horizontal() {
        // Arrange
        int[][] matrix = { {1, 2}, {3, 4} };
        int[][] expectedResult = { {2, 1}, {4, 3} };

        runTest(matrix, expectedResult, FlipDirection.HORIZONTAL);
    }

    @Test
    void flipMatrix3x3Vertical() {
        // Arrange
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] expectedResult = { {7, 8, 9}, {4, 5, 6}, {1, 2, 3} };

        runTest(matrix, expectedResult, FlipDirection.VERTICAL);
    }

    @Test
    void flipMatrix3x3Horizontal() {
        // Arrange
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] expectedResult = { {3, 2, 1}, {6, 5, 4}, {9, 8, 7} };

        runTest(matrix, expectedResult, FlipDirection.HORIZONTAL);
    }

    private static void runTest(int[][] matrix, int[][] expectedResult, FlipDirection flipDirection) {
        // Act
        int[][] result = Main.flipMatrix(matrix, flipDirection);

        // Assert
        Assertions.assertArrayEquals(expectedResult, result);
    }
}