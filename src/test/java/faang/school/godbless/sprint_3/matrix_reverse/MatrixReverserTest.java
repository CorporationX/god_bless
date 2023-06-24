package faang.school.godbless.sprint_3.matrix_reverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixReverserTest {
    int[][] twoDimensionalArray;
    @BeforeEach
    void init(){
        twoDimensionalArray = new int[][]{{1, 2, 2, 2, 2},
                {2, 3, 3, 3, 3},
                {3, 4, 4, 4, 4}};
    }

    @Test
    void transformMatrixTest() {
        int[][] expected = {{3, 4, 4, 4, 4},
                            {2, 3, 3, 3, 3},
                            {1, 2, 2, 2, 2}};
        int[][] result = MatrixReverser.transformMatrix(twoDimensionalArray, (x, y) -> new Coordinates(twoDimensionalArray.length - 1 - x, y));
        assertArrayEquals(expected, result);
    }

    @Test
    void transformMatrixOnEmptyArrayIncoming(){
        int[][] emptyArray = new int[0][0];
        int[][] emptyResult = MatrixReverser.transformMatrix(emptyArray, (x, y) -> new Coordinates(twoDimensionalArray.length - 1 - x, y));

        assertArrayEquals(emptyArray, emptyResult);
    }
    @Test
    void flipMatrixFirstTest() {
        int[][] firstDimensionalArray = {{1, 2, 3, 4, 5},
                                         {2, 3, 4, 5, 6},
                                         {3, 4, 5, 6, 7}};
        int[][] firstExpected = {{5, 4, 3, 2, 1},
                                 {6, 5, 4, 3, 2},
                                 {7, 6, 5, 4, 3}};

        int[][] firstResult = MatrixReverser.flipMatrix(firstDimensionalArray, FlipDirection.HORIZONTAL);

        assertEquals(firstExpected[1][4], firstResult[1][4]);
    }
    @Test
    void flipMatrixSecondTest(){
        int[][] secondDimensionalArray = {{1, 1, 1, 1, 1},
                                          {2, 2, 2, 2, 2},
                                         {3, 3, 3, 3, 3}};
        int[][] secondExpected = {{3, 3, 3, 3, 3},
                                  {2, 2, 2, 2, 2},
                                  {1, 1, 1, 1, 1}};
        int[][] secondResult = MatrixReverser.flipMatrix(secondDimensionalArray, FlipDirection.VERTICAL);

        assertArrayEquals(secondExpected, secondResult);
    }
    @Test
    void flipMatrixEmptyArrayTest(){
        int[][] emptyArray = new int[0][0];
        int[][] emptyResult = MatrixReverser.flipMatrix(emptyArray, FlipDirection.HORIZONTAL);

        assertArrayEquals(emptyArray, emptyResult);
    }
}