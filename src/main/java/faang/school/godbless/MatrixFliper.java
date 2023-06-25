package faang.school.godbless;

public class MatrixFliper {
    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transformedMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                int newX = newCoordinates.getX();
                int newY = newCoordinates.getY();
                transformedMatrix[newX][newY] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] flippedMatrix = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                int newX, newY;

                if (flipDirection == FlipDirection.HORIZONTAL) {
                    newX = i;
                    newY = columns - 1 - j;
                } else {
                    newX = rows - 1 - i;
                    newY = j;
                }
                flippedMatrix[newX][newY] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }
}
