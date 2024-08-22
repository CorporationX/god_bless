package faang.school.godbless.MatrixMath;

public class Tests {
    public static void main(String[] args) {
        testMatrixFlip(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        testMatrixFlip(new int[][]{{}});
    }

    private static void testMatrixFlip(int[][] matrix) {
        System.out.println("Original matrix:");
        printMatrix(matrix);

        int[][] flippedHorizontally = MatrixMath.flipMatrix(matrix, MatrixMath.FlipDirection.HORIZONTAL);
        System.out.println("Horizontally flipped matrix:");
        printMatrix(flippedHorizontally);

        int[][] flippedVertically = MatrixMath.flipMatrix(matrix, MatrixMath.FlipDirection.VERTICAL);
        System.out.println("Vertically flipped matrix:");
        printMatrix(flippedVertically);

        System.out.println("\n");
    }

    private static void printMatrix(int[][] matrix) {
       for (int[] row : matrix) {
           for (int value : row) {
               System.out.print(value + " ");
           }
           System.out.println();
        }
    }
}
