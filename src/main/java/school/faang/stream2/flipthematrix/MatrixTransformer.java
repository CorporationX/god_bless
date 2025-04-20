package school.faang.stream2.flipthematrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int indexX, int indexY);

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                result[coordinates.coordinateX()][coordinates.coordinateY()] = matrix[i][j];
            }
        }
        return result;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case VERTICAL -> transformMatrix(matrix, (x, y) ->
                    new Coordinates(x, matrix[0].length - 1 - y)
            );
            case HORIZONTAL -> transformMatrix(matrix, (x, y) ->
                    new Coordinates(matrix[0].length - 1 - x, y)
            );
        };
    }
}
