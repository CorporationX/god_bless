package faang.school.godbless;

import static faang.school.godbless.FlipDirection.flipMatrix;

public class Application {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] horizontallyFlipped = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        printMatrix(horizontallyFlipped);

        int[][] verticallyFlipped = flipMatrix(matrix, FlipDirection.VERTICAL);
        printMatrix(verticallyFlipped);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
