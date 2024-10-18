package bjs2_33394;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {3, 4, 5, 6}, {5, 6, 7, 8}, {7, 8, 9, 10}, {9, 10, 11 ,12}};

        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.VERTICAL)));
        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.HORIZONTAL)));
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                transformedMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - x - 1, y));
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        } else {
            System.out.println("Invalid flip direction. Returning original Matrix");
            return matrix;
        }
    }
}
