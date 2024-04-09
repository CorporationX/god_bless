package faang.school.godbless.BJS2_5005;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] marixTest = new int[2][4];
        marixTest[0] = new int[]{1, 2, 3, 4};
        marixTest[1] = new int[]{5, 6, 7, 8};

        int[][] horizontalMatrix = flipMatrix(marixTest, FlipDirection.HORIZONTAL);
        printMatrix(horizontalMatrix, FlipDirection.HORIZONTAL);
        System.out.println("-----------------------------");
        int[][] verticalMatrix = flipMatrix(marixTest, FlipDirection.VERTICAL);
        printMatrix(horizontalMatrix, FlipDirection.VERTICAL);
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates newCoordinates = transformer.matrixTrans(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer = (x, y) ->
                switch (flipDirection) {
                    case HORIZONTAL -> new Coordinates(x, matrix[0].length - 1 - y);
                    case VERTICAL -> new Coordinates(matrix.length - 1 - x, y);
                };
        return transformMatrix(matrix, transformer);
    }

    static void printMatrix(int[][] matrix, FlipDirection flipDirection) {
        System.out.printf("%s rotation %n", flipDirection.name());
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    @FunctionalInterface
    interface MatrixTransformer {
        Coordinates matrixTrans(int a, int b);
    }
}