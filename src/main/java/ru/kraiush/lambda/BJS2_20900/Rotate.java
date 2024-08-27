package ru.kraiush.lambda.BJS2_20900;

public class Rotate {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        return transformer.transformMatrix(matrix);
    }

    static int[][] flipMatrix(int[][] input, FlipDirection.RotateType type) {

        return transformMatrix(input ,(q) -> {
            var rows = input[0].length;
            var columns = input.length;
            var result = new int[rows][columns];
            for (var i = 0; i < rows; i++) {
                for (var j = 0; j < columns; j++) {
                    result[i][j] = (type == FlipDirection.RotateType.LEFT) ?
                            input[j][rows - 1 - i] :
                            input[columns - 1 - j][i];
                }
            }
            return result;
        });
    }
}
