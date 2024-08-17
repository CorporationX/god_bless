package faang.school.godbless.BJS2_20565;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Horizontal:");
        System.out.println(Arrays.toString(flipMatrix(matrix, FlipDirection.HORIZONTAL)));
        System.out.println("Vertical:");
        System.out.println(Arrays.toString(flipMatrix(matrix, FlipDirection.VERTICAL)));

    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transformMatrix(i, j);
                newMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection direction) {

        MatrixTransformer transformer =
                switch (direction) {
                    case HORIZONTAL -> (x, y) -> new Coordinates(x, matrix.length - 1 - y);
                    case VERTICAL -> (x, y) -> new Coordinates(matrix[0].length - 1 - x, y);
        };
        return transformMatrix(matrix, transformer);
    }
}
