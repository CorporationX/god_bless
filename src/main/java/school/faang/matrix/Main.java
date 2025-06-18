package school.faang.matrix;

import static school.faang.matrix.FlipDirection.HORIZONTAL;
import static school.faang.matrix.FlipDirection.VERTICAL;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        testMatrixTransform(matrix);

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        testMatrixTransform(matrix2);

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        testMatrixTransform(matrix3);
    }

    private static void testMatrixTransform(int[][] matrix) {
        System.out.println("Оригинальная матрица:");
        printMatrix(matrix);

        System.out.println("Горизонтальный переворот:");
        var flippedHorizontalMatrix = MatrixTransformer.flipMatrix(matrix, HORIZONTAL);
        printMatrix(flippedHorizontalMatrix);

        System.out.println("Вертикальный переворот:");
        var flippedVerticalMatrix = MatrixTransformer.flipMatrix(matrix, VERTICAL);
        printMatrix(flippedVerticalMatrix);

        System.out.println();
    }


    private static void printMatrix(int[][] matrix) {
        for (var row : matrix) {
            System.out.print("[");
            for (int col = 0; col < row.length; col++) {
                if (col == row.length - 1) {
                    System.out.print(row[col]);
                } else {
                    System.out.print(row[col] + ", ");
                }
            }
            System.out.println("]");
        }
    }
}
