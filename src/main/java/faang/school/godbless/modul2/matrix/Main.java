package faang.school.godbless.modul2.matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        var horizontalMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        Arrays.stream(horizontalMatrix).forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println();

        var verticalMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        Arrays.stream(verticalMatrix).forEach(o -> System.out.println(Arrays.toString(o)));
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer = (row, col) -> {
            if (flipDirection == FlipDirection.VERTICAL) {
                return new Coordinates(matrix.length - row - 1, col);
            } else {
                return new Coordinates(row, matrix[0].length - col - 1);
            }
        };
        return transformMatrix(matrix, transformer);
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        var transformedMatrix = new int[matrix.length][matrix[0].length];

        IntStream.range(0, matrix.length).forEach(row ->
                IntStream.range(0, matrix[0].length).forEach(col -> {
                    Coordinates newCoordinates = transformer.transform(row, col);
                    transformedMatrix[newCoordinates.getY()][newCoordinates.getX()] = matrix[row][col];
                })
        );
        return transformedMatrix;
    }
}
