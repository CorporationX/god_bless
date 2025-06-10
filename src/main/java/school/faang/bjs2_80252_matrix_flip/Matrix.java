package school.faang.bjs2_80252_matrix_flip;

public class Matrix {
    public static int[][] transformMatrix(int[][] matrixOriginal, MatrixTransformer transformer) {
        if (matrixOriginal == null) {
            return null;
        }
        int[][] newMatrix = deepCopy(matrixOriginal);
        for (int r = 0; r < newMatrix.length; r++) {
            int[] row = newMatrix[r];
            for (int x = 0; x < row.length; x++) {
                Coordinates newCoordinates = transformer.toCoordinates(x, r);
                int temp = newMatrix[newCoordinates.getCoordinateY()][newCoordinates.getCoordinateX()];
                newMatrix[newCoordinates.getCoordinateY()][newCoordinates.getCoordinateX()] = newMatrix[r][x];
                newMatrix[r][x] = temp;
            }
        }
        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        StringBuilder output = new StringBuilder();
        for (int[] row : matrix) {
            output.append("[");
            for (int i : row) {
                output.append(" ").append(i);
            }
            output.append(" ]\n");
        }
        System.out.println(output);
    }

    private static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer verticalTransformer = (x, y) -> {
            if (x < matrix[0].length / 2) {
                return new Coordinates(matrix[0].length - 1 - x, y);
            }
            return new Coordinates(x, y);
        };

        MatrixTransformer horizontalTransformer = (x, y) -> {
            if (y < matrix.length / 2) {
                return new Coordinates(x, matrix.length - 1 - y);
            }
            return new Coordinates(x, y);
        };

        return switch (flipDirection) {
            case VERTICAL -> transformMatrix(matrix, verticalTransformer);
            case HORIZONTAL -> transformMatrix(matrix, horizontalTransformer);
            default -> matrix;
        };
    }
}
