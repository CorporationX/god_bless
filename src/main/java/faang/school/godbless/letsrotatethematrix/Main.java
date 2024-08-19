package faang.school.godbless.letsrotatethematrix;

import static faang.school.godbless.letsrotatethematrix.MatrixUtils.flipMatrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Original Matrix: ");
        printMatrix(matrix);

        int[][] flipHorizontally = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("Flip Horizontally: ");
        printMatrix(flipHorizontally);

        int[][] flipVertically = flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("Flip Vertically: ");
        printMatrix(flipVertically);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}