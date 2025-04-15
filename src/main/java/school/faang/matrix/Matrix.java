package school.faang.matrix;

import lombok.NonNull;

public class Matrix {

    static int[][] transformMatrix(@NonNull int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                Coordinates newPair = transformer.execute(x, y);
                result[newPair.getCoordinateX()][newPair.getCoordinateY()] = matrix[x][y];
            }
        }
        return result;
    }

    static int[][] flipMatrix(@NonNull int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return transformMatrix(matrix, (x, y) -> switch (flipDirection) {
            case HORIZONTAL -> new Coordinates(x, cols - 1 - y);
            case VERTICAL -> new Coordinates(rows - 1 - x, y);
        });
    }
}
