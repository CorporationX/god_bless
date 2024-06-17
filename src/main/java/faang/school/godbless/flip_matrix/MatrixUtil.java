package faang.school.godbless.flip_matrix;

public class MatrixUtil {
    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int length = matrix.length;
        int[][] transformedMatrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Coordinates coords = transformer.transform(new Coordinates(i, j));
                transformedMatrix[coords.x()][coords.y()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int length = matrix.length;
        return transformMatrix(matrix, coordinates -> {
            return switch (flipDirection) {
                case VERTICAL -> new Coordinates(length - 1 - coordinates.x(), coordinates.y());
                case HORIZONTAL -> new Coordinates(coordinates.x(), length - 1 - coordinates.y());
                default -> throw new IllegalArgumentException(flipDirection + " is incompatible enum value;");
            };
        });
    }
}
