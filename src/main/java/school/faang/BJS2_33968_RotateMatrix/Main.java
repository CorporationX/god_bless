package school.faang.BJS2_33968_RotateMatrix;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] horizontallyFlipped = MatrixOperations.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("Horizontally Flipped Matrix:");
        printMatrix(horizontallyFlipped);

        int[][] verticallyFlipped = MatrixOperations.flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("Vertically Flipped Matrix:");
        printMatrix(verticallyFlipped);
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
                .forEach(row -> {
                    Arrays.stream(row).forEach(elem -> System.out.print(elem + " "));
                    System.out.println();
                });
    }
}
