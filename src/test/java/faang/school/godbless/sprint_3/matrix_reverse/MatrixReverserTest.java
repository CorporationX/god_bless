package faang.school.godbless.sprint_3.matrix_reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixReverserTest {

    @Test
    void transformMatrixTest() {
        int[][] twoDimensionalArray = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int[][] expected = {{1, 2, 3}, {1, 2, 3}};
        int[][] result = MatrixReverser.transformMatrix(twoDimensionalArray, (Coordinates::new));

        assertNotEquals(0, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    void flipMatrixTest() {
        int[][] firstDimensionalArray = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}};
        int[][] firstExpected = {{5, 4, 3, 2, 1}, {6, 5, 4, 3, 2}, {7, 6, 5, 4, 3}};
        int[][] firstResult = MatrixReverser.flipMatrix(firstDimensionalArray, FlipDirection.HORIZONTAL);

        assertArrayEquals(firstExpected, firstResult);
        assertEquals(firstExpected[1][4], firstResult[1][4]);

        int[][] secondDimensionalArray = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}};
        int[][] secondExpected = {{3, 3, 3, 3, 3}, {2, 2, 2, 2, 2}, {1, 1, 1, 1, 1}};
        int[][] secondResult = MatrixReverser.flipMatrix(secondDimensionalArray, FlipDirection.VERTICAL);

        assertArrayEquals(secondExpected, secondResult);
        assertEquals(secondExpected[1][2], secondResult[1][2]);

        int[][] emptyArray = new int[0][];

        assertThrows(IllegalArgumentException.class, () -> MatrixReverser.flipMatrix(emptyArray, FlipDirection.HORIZONTAL));
    }

    @Test
    void transformMatrixThrowsArrayIndexOfBoundException() {
        int[][] wrongDimensionArray = new int[][]{{1}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int[][] emptyMassive = new int[0][];

        assertThrows(IllegalArgumentException.class, () -> MatrixReverser.transformMatrix(emptyMassive, (Coordinates::new)));
        assertThrows(IllegalArgumentException.class, () -> MatrixReverser.transformMatrix(wrongDimensionArray, (Coordinates::new)));
    }
}