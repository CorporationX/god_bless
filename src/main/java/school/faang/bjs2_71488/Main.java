package school.faang.bjs2_71488;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[][] originalMatrix = {{1, 2}, {3, 4}};
        log.info("Original matrix {}.", Arrays.deepToString(originalMatrix));
        log.info("Horizontally flipped matrix {}.", Arrays.deepToString(flipMatrix(originalMatrix, FlipDirection.HORIZONTAL)));
        log.info("Vertically flipped matrix {}.", Arrays.deepToString(flipMatrix(originalMatrix, FlipDirection.VERTICAL)));
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newMatrix = new int[matrix[0].length][matrix[1].length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                Coordinate coordinate = transformer.trnaform(i, j);
                newMatrix[coordinate.getCoordinateX()][coordinate.getCoordinateY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer = (x, y) -> new Coordinate(x, y);
        switch (flipDirection) {
            case HORIZONTAL:
                transformer = (x, y) -> {
                    return new Coordinate(x, matrix.length - 1 - y);
                };
                // 0, 0 -> 0, 1   
                // 0, 1 -> 0, 0
                // 1, 0 -> 1, 1
                // 1, 1 -> 1, 0
                break;
            case VERTICAL:
                transformer = (x, y) -> {
                    return new Coordinate(matrix.length - 1 - x, y);
                };
                // 0, 0 -> 1, 0   
                // 0, 1 -> 1, 1
                // 1, 0 -> 0, 0
                // 1, 1 -> 0, 1
                break;
            default:
                throw new IllegalArgumentException("Illegal flip direction.");
        }
        return transformMatrix(matrix, transformer);
    }
}
