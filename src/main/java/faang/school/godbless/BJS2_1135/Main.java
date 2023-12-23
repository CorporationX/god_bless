package faang.school.godbless.BJS2_1135;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 6},
                {3, 2, 5},
                {3, 4, 1}
        };

        MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(y, x);

        System.out.println("original matrix:");
        printMatrix(matrix);

        System.out.println("transformed matrix:");
        printMatrix(transformMatrix(matrix, matrixTransformer));

        System.out.println("vertical flipped matrix:");
        printMatrix(flipMatrix(matrix, FlipDirection.VERTICAL));

        System.out.println("horizontal flipped matrix:");
        printMatrix(flipMatrix(matrix, FlipDirection.HORIZONTAL));
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                var coordinates = transformer.transform(x, y);
                int newX = coordinates.getX();
                int newY = coordinates.getY();

                newMatrix[newX][newY] = matrix[x][y];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer matrixTransformer = switch (flipDirection) {
            case HORIZONTAL -> (x, y) -> new Coordinates(x, matrix.length - 1 - y);
            case VERTICAL -> (x, y) -> new Coordinates(matrix.length - 1 - x, y);
        };

        return transformMatrix(matrix, matrixTransformer);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] innerArray : matrix) {
            System.out.println(Arrays.toString(innerArray));
        }
    }
}