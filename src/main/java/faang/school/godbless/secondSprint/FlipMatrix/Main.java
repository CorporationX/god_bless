package faang.school.godbless.secondSprint.FlipMatrix;

public class Main {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int matrixLength = matrix.length;
        int matrixWidth = matrix[0].length;
        int[][] newMatrix = new int[matrixLength][matrixWidth];

        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                Coordinates coordinates = transformer.transform(new Coordinates(i, j));
                newMatrix[coordinates.x()][coordinates.y()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int matrixLength = matrix.length;
        if (matrixLength == 0) {
            return new int[0][0];
        }

        int[][] invertedMatrix;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            MatrixTransformer matrixTransformer = (coordinates) -> new Coordinates(coordinates.x(),
                    matrix[0].length - coordinates.y() - 1);
            invertedMatrix = transformMatrix(matrix, matrixTransformer);
        } else if (flipDirection == FlipDirection.VERTICAL) {
            MatrixTransformer matrixTransformer = (coordinates) ->
                    new Coordinates(matrixLength - 1 - coordinates.x(), coordinates.y());
            invertedMatrix = transformMatrix(matrix, matrixTransformer);
        } else {
            throw new IllegalArgumentException("Invalid flipDirection value");
        }

        return invertedMatrix;
    }
}
