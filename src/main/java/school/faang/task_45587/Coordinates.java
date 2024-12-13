package school.faang.task_45587;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Coordinates {
    private final int coordinateX;
    private final int coordinateY;

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == null) {
            log.error("Некорретное значение поворота матрицы!");
            return new int[0][0];
        }

        switch (flipDirection) {
          case VERTICAL -> {
              return transformMatrix(matrix, (x, y) ->
                new Coordinates(matrix.length - 1 - x, y)
            );
          }
          case HORIZONTAL -> {
              return transformMatrix(matrix, (x, y) ->
                new Coordinates(x, matrix[0].length - 1 - y)
            );
          }
          default -> {
              throw new IllegalArgumentException("Некорретное значение поворота матрицы!");
          }
        }
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i].length == 0 || matrix[i].length != matrix[i + 1].length) {
                return new int[0][0];
            }
        }

        var rows = matrix.length;
        var columns = matrix[0].length;
        var newMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                var newCoordinates = transformer.replaceCoordinates(i, j);
                newMatrix[newCoordinates.getCoordinateX()][newCoordinates.getCoordinateY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
