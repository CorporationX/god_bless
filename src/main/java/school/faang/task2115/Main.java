package school.faang.task2115;

import school.faang.task2115.matrix.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}};

        matrix = Matrix.flipMatrix(matrix, FlipDirection.HORIZONTAL);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
