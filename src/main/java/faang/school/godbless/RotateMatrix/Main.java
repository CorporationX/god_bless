package faang.school.godbless.RotateMatrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16},
                new int[]{17, 18, 19, 20}
        };

        int[][] verticalMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        Arrays.stream(verticalMatrix).forEach(o -> System.out.println(Arrays.toString(o)));

        System.out.println();
        int[][] horizontalMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        Arrays.stream(horizontalMatrix).forEach(o -> System.out.println(Arrays.toString(o)));
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                Coordinates newCoordinates = transformer.transform(row, col);
                transformedMatrix[newCoordinates.getY()][newCoordinates.getX()] = matrix[row][col];
            }
        }
        return transformedMatrix;
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer = (row, col) -> switch (flipDirection) {
            case VERTICAL -> new Coordinates(matrix.length - row - 1, col);
            case HORIZONTAL -> new Coordinates(row, matrix[0].length - col - 1);
        };
        return transformMatrix(matrix, transformer);
    }
}