package faang.school.godbless.functionalInterfaces.matrix;

public class TransformProcessor {
    public double[][] flipMatrix(double[][] matrix, FlipDirection direction) {
        if (matrix == null || direction == null) {
            throw new IllegalArgumentException("Args must be non-valued!");
        }

        if (matrix.length == 0) {
            throw new IllegalArgumentException("The Matrix must have values!");
        }

        for (var row : matrix) {
            if (matrix.length != row.length) {
                throw new IllegalArgumentException("The matrix must be  square!");
            }
        }

        MatrixTransformer verticalFlipper = (element, dim) -> new Coordinates(element.x(), dim - element.y() - 1);
        MatrixTransformer horizontalFlipper = (element, dim) -> new Coordinates(dim - element.x() - 1, element.y());

        if (direction == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, horizontalFlipper);
        }

        if (direction == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, verticalFlipper);
        }

        return matrix;
    }

    public double[][] transformMatrix(double[][] originalMatrix, MatrixTransformer transformer) {
        int dim = originalMatrix.length; //matrix dimension
        double[][] transformedMatrix = new double[dim][dim];

        for (int y = 0; y < dim; y++) {
            for (int x = 0; x < dim; x++) {
                var newCoordinates = transformer.transform(new Coordinates(x, y), dim);
                transformedMatrix[newCoordinates.y()][newCoordinates.x()] = originalMatrix[y][x];
            }
        }

        return transformedMatrix;
    }
}
