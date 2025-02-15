package school.faang.reversematrix;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final int[][] ODD_MATRIX = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
    };
    private static final int[][] EVEN_MATRIX = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36}
    };
    private static final MatrixTransformer horizontalTransformer = (indexRow, indexColumn, size) ->
            new Coordinates(size - 1 - indexRow, indexColumn);
    private static final MatrixTransformer verticalTransformer = (indexRow, indexColumn, size) ->
            new Coordinates(indexRow, size - 1 - indexColumn);

    public static void main(String[] args) {
        log.info("\nOdd matrix:\n{}", printMatrix(ODD_MATRIX));
        log.info("\nHorizontal flip:\n{}", printMatrix(flipMatrix(ODD_MATRIX, FlipDirection.HORIZONTAL)));
        log.info("\nVertical flip:\n{}", printMatrix(flipMatrix(ODD_MATRIX, FlipDirection.VERTICAL)));
        log.info("\nEven matrix:\n{}", printMatrix(EVEN_MATRIX));
        log.info("\nHorizontal flip:\n{}", printMatrix(flipMatrix(EVEN_MATRIX, FlipDirection.HORIZONTAL)));
        log.info("\nVertical flip:\n{}", printMatrix(flipMatrix(EVEN_MATRIX, FlipDirection.VERTICAL)));
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        Objects.requireNonNull(transformer);
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                Coordinates newCoordinates = transformer.transform(row, column, matrix.length);
                newMatrix[newCoordinates.getIndexRow()][newCoordinates.getIndexColumn()] = matrix[row][column];
            }
        }
        return newMatrix;
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection direction) {
        validateParameters(matrix, direction);
        if (direction.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, horizontalTransformer);
        } else {
            return transformMatrix(matrix, verticalTransformer);
        }
    }

    private static String printMatrix(int[][] matrix) {
        return Arrays.stream(matrix).map(Arrays::toString).collect(Collectors.joining("\n"));
    }

    private static void validateParameters(int[][] matrix, FlipDirection direction) {
        Objects.requireNonNull(direction, "Invalid flip direction");
        Objects.requireNonNull(matrix, "Invalid matrix");
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is empty");
        } else if (matrix[0].length != matrix.length) {
            throw new IllegalArgumentException("Matrix is not square");
        }
    }
}
