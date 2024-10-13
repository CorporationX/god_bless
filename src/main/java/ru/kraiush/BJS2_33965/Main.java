package ru.kraiush.BJS2_33965;

public class Main {

    enum FlipDirection {
        HORIZONTAL,
        VERTICAL
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transformedMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                transformedMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - y - 1));
        } else if (flipDirection.equals(FlipDirection.VERTICAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - x - 1, y));
        } else {
            throw new IllegalArgumentException("Invalid flip direction");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4, 2},
                {5, 6, 7, 8, 4},
                {9, 10, 11, 12, 0},
                {13, 14, 15, 16, 4},
                {17, 18, 19, 20, 5}
        };

        printMatrix(flipMatrix(matrix, FlipDirection.HORIZONTAL));
        System.out.println("________");
        printMatrix(flipMatrix(matrix, FlipDirection.VERTICAL));
    }
}
