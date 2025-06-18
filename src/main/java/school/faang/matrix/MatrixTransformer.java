package school.faang.matrix;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@FunctionalInterface
public interface MatrixTransformer {

    /**
     * @param x Индекс строки
     * @param y Индекс столбца
     * @return Координаты с новыми индексами для замены значения в матрице
     */
    Coordinates swap(int x, int y);

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        var newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                var newCoordinates = transformer.swap(i, j);
                newMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        switch (flipDirection) {
            case HORIZONTAL -> {
                MatrixTransformer transformer = (x, y) -> new Coordinates(x, matrix[0].length - 1 - y);
                return transformMatrix(matrix, transformer);
            }
            case VERTICAL -> {
                MatrixTransformer transformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
                return transformMatrix(matrix, transformer);
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + flipDirection);
        }
    }
}
