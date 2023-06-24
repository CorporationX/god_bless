package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransformerTest {
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new Transformer();
    }

    @Test
    void testFlipVertical() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        int[][] flippedMatrix = transformer.flipMatrix(matrix, FlipDirection.VERTICAL);
        assertArrayEquals(flippedMatrix, expected);
    }

    @Test
    public void testFlipHORIZONTAL() {
        Transformer transformer = new Transformer();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };
        int[][] flippedMatrix = transformer.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        assertArrayEquals(expected, flippedMatrix);
    }

    @Test
    public void testFlipEmpty() {
        int[][] matrix = {};
        assertThrows(IllegalArgumentException.class,
                () -> transformer.flipMatrix(matrix, FlipDirection.HORIZONTAL));
    }
}