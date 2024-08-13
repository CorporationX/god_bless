package faang.school.godbless.modul2.matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(matrix);
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(row ->
                System.out.println(String.join(" ", Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new))));
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (flipDirection == FlipDirection.VERTICAL) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols / 2; j++) {
                    swapElements(matrix, transformer, i, j);
                }
            }
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows / 2; i++) {
                    swapElements(matrix, transformer, i, j);
                }
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + flipDirection);
        }
        return matrix;
    }

    public static void swapElements(int[][] matrix, MatrixTransformer transformer, int i, int j) {
        var coordinates = transformer.transform(i, j);
        var tmp = matrix[i][j];
        matrix[i][j] = matrix[coordinates.getX()][coordinates.getY()];
        matrix[coordinates.getX()][coordinates.getY()] = tmp;
    }
}
