package faang.school.godbless.sprint3.ReverceMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testFlipMatrix2() {
        int[][] input = new int[][]{{1, 2},
                {3, 4}};
        int[][] expect = new int[][]{{2, 1},
                {4, 3}};
        assertArrayEquals(expect, Main.flipMatrix(input, (line) -> {
            faang.school.godbless.Sprint2.task5.Example.reverse((int[]) line);
            return line;
        }));
    }

    @Test
    void testFlipMatrix3() {
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] expect = new int[][]{{3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}};
        assertArrayEquals(expect, Main.flipMatrix(input, (line) -> {
            faang.school.godbless.Sprint2.task5.Example.reverse((int[]) line);
            return line;
        }));
    }
    @Test
    void testFlipMatrixNull() {
        int[][] input = new int[][]{};
        int[][] expect = new int[][]{};
        assertArrayEquals(expect, Main.flipMatrix(input, (line) -> {
            faang.school.godbless.Sprint2.task5.Example.reverse((int[]) line);
            return line;
        }));
    }
}