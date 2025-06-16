package school.faang.bjs2_80272;

public class TransformationManager {
    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformedMatrix = new int[matrix.length][matrix.length];
        Coordinates bufferCoordinate;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                bufferCoordinate = transformer.transform(x, y);
                transformedMatrix[bufferCoordinate.getCoordinateX()][bufferCoordinate.getCoordinateY()] = matrix[x][y];
            }
        }
        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int[][] flippedMatrix;
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            flippedMatrix = transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix.length - 1 - y));
        } else if (flipDirection.equals(FlipDirection.VERTICAL)) {
            flippedMatrix = transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        } else {
            throw new IllegalArgumentException("Invalid Flip Direction");
        }
        return flippedMatrix;

    }
}
