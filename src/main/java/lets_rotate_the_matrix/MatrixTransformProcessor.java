package lets_rotate_the_matrix;

public class MatrixTransformProcessor {
    /**
     * Applies a transformation to the given matrix and returns the result.
     *
     * <p>The given matrix is transformed into a new matrix by applying the given
     * transformation to each element of the original matrix. The transformation is
     * done by calling the
     * {@link MatrixTransformer#transform(int, int)} method on the transformer object.
     *
     * @param matrix the matrix to be transformed
     * @param transformer the transformation to be applied to the matrix
     * @return a new matrix that is the result of the transformation
     */
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }

        return newMatrix;
    }


    /**
     * Flips the given matrix horizontally or vertically, depending on the given
     * {@link FlipDirection}.
     *
     * <p>If the given direction is {@link FlipDirection#HORIZONTAL}, this method
     * flips the matrix about the horizontal middle line. If the given direction is
     * {@link FlipDirection#VERTICAL}, this method flips the matrix about the vertical
     * middle line.
     *
     * @param matrix the matrix to be flipped
     * @param flipDirection the direction of the flip
     * @return the flipped matrix
     */
    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case HORIZONTAL -> transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
            case VERTICAL -> transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
            default -> throw new IllegalArgumentException("Invalid flip direction");
        };
    }
}
