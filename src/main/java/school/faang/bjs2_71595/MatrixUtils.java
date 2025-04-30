package school.faang.bjs2_71595;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MatrixUtils {
    public static int[][] transformMatrix(@NonNull int[][] matrix, @NonNull MatrixTransformer transformer) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Coordinates transformed = transformer.transform(i, j);
                result[transformed.coordinateX()][transformed.coordinateY()] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] flipMatrix(@NonNull int[][] matrix, @NonNull FlipDirection flipDirection) {
        MatrixTransformer transformer = switch (flipDirection) {
            case HORIZONTAL -> (row, column) -> new Coordinates(row, matrix.length - column - 1);
            case VERTICAL -> (row, column) -> new Coordinates(matrix.length - row - 1, column);
        };

        return transformMatrix(matrix, transformer);
    }

    public static void printMatrix(int[][] matrix) {
        log.info("Matrix {}x{}:", matrix.length, matrix.length);
        for (int[] row : matrix) {
            log.info(Arrays.toString(row));
        }
    }
}
