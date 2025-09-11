package school.faang.bjs2_87247;

public class MatrixFlip {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty");
        }
        int one = matrix.length;
        int two = matrix[0].length;
        int[][] result = new int[one][two];

        for (int i = 0; i < one; i++) {
            for (int j = 0; j < two; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                result[coordinates.getCoordinateX()][coordinates.getCoordinateY()] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty");
        }
        int one = matrix.length;
        int two = matrix[0].length;

        return switch (flipDirection) {
            case HORIZONTAL -> transformMatrix(matrix, (i, j) ->
                    new Coordinates(i, two - 1 - j));
            case VERTICAL -> transformMatrix(matrix, (i, j) ->
                    new Coordinates(one - 1 - i, j));
        };
    }
}
