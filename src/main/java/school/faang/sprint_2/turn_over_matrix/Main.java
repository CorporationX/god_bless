package school.faang.sprint_2.turn_over_matrix;

import static school.faang.sprint_2.turn_over_matrix.MatrixService.flipMatrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        print(matrix);
        matrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        print(matrix);
        matrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
