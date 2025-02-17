package bjs2_57242;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2, 3}, {4, 5, 6}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        transformAndShow(matrix);
        System.out.println();

        matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transformAndShow(matrix);
    }

    private static void transformAndShow(int[][] matrix) {
        System.out.println("Initial matrix");
        showMatrix(matrix);

        System.out.println("Vertical transformation");
        int[][] verticalTransformation = MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL);
        showMatrix(verticalTransformation);

        System.out.println("Horizontal transformation");
        int[][] horizontalTransformation = MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        showMatrix(horizontalTransformation);
    }

    private static void showMatrix(int[][] matrix) {
        for (int[] rowData : matrix) {
            System.out.println(Arrays.toString(rowData));
        }
    }
}
