package faang.school.godbless.matrixRotate;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[][] matrixHorizontalFlipped = MatrixProcessor.flipMatrix(getMatrix(), FlipDirection.HORIZONTAL);
        System.out.println(Arrays.deepToString(matrixHorizontalFlipped));

        System.out.println("\n\n");

        int[][] matrixVerticalFlipped = MatrixProcessor.flipMatrix(getMatrix(), FlipDirection.VERTICAL);
        System.out.println(Arrays.deepToString(matrixVerticalFlipped));
    }

    /**
     * Return:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @return int[][]
     */
    private static int[][] getMatrix() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        return matrix;
    }
}
