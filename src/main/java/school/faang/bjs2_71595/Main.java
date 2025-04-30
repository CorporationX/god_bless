package school.faang.bjs2_71595;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        log.info("Before transforming:");
        MatrixUtils.printMatrix(matrix);

        log.info("Horizontally transposing:");
        int[][] flippedHorizontally = MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        MatrixUtils.printMatrix(flippedHorizontally);

        log.info("Vertically transposing:");
        int[][] flippedVertically = MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL);
        MatrixUtils.printMatrix(flippedVertically);

        log.info("Transformation:");
        int[][] transposed = MatrixUtils.transformMatrix(matrix, (row, column) -> new Coordinates(column, row));
        MatrixUtils.printMatrix(transposed);
    }
}
