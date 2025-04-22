package school.faang.sprint_2.turn_over_matrix;

public class MatrixService {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols]; // предполагаем, что размер не меняется

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates coords = transformer.transform(i, j);
                result[coords.getCooridnateX()][coords.getCooridnateY()] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        MatrixTransformer transformer = switch (flipDirection) {
            case HORIZONTAL -> (i, j) -> new Coordinates(rows - 1 - i, j);
            case VERTICAL -> (i, j) -> new Coordinates(i, cols - 1 - j);
        };
        return transformMatrix(matrix, transformer);
    }
}
