package faang.school.godbless.sprint2.transformMatrix;

public class MatrixFlipper {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0){
            return new int[0][0];
        }
        int[][] newMatrix = new int [matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; ++i){
            for (int k = 0; k < matrix[0].length; ++k){
                Coordinates coordinates = transformer.transform(i,k);
                newMatrix[coordinates.x()][coordinates.y()] = matrix[i][k];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer matrixTransformer;
        if (flipDirection == FlipDirection.VERTICAL) {
            matrixTransformer = (x, y) -> new Coordinates(matrix[0].length - x - 1, y);
        } else {
            matrixTransformer = ((x, y) -> new Coordinates(x, matrix.length - y - 1));
        }
        return transformMatrix(matrix,matrixTransformer);
    }
}
