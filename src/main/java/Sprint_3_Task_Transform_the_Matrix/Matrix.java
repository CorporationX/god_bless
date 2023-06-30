package Sprint_3_Task_Transform_the_Matrix;

import java.util.Arrays;

public class Matrix {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                var newCoordinates = transformer.matrixTransforming(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int z;
                int a;

                if (flipDirection == FlipDirection.HORIZONTAL) {
                    z = i;
                    a = matrix[0].length - j - 1;
                } else {
                    z = matrix.length - i - 1;
                    a = j;
                }
                newMatrix[i][j] = matrix[z][a];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {

        //int[][] matrix = {{17, 27, 5, 7}, {37, 74, 7, 67}, {32, 41, 73, 7}};
        int[][] matrix = {{17, 27},
                {7, 67}};

        MatrixTransformer transformer = (x, y) -> new Coordinates(y, x);
        int[][] transformedMatrix = transformMatrix(matrix, transformer);
        System.out.println(Arrays.deepToString(transformedMatrix));

        FlipDirection flipDirection = FlipDirection.HORIZONTAL;
        int[][] flippedMatrix = flipMatrix(transformedMatrix, flipDirection);
        System.out.println(Arrays.deepToString(flippedMatrix));

        FlipDirection flipDirection1 = FlipDirection.VERTICAL;
        int[][] flippedMatrix1 = flipMatrix(transformedMatrix, flipDirection1);
        System.out.println(Arrays.deepToString(flippedMatrix1));
        System.out.println(Arrays.deepToString(matrix));

//Задача работает только с двумерными матрицами.
//Если сначала делать транспонирование матрицы методом transformMatrix
//(транспонируем, по сути, в лямбде (x, y) -> new Coordinates(y, x);)
//и потом поворачиваем ее методом flipMatrix,
//То в резльтате будет, ественно не повернутая матрица, а транспонированная, и затем толькоповернутая.

        //видимо в задаче предполагается все-таки сначала транспонировать, а затем повернуть матрицу.
        //но у условии указано выполнить два метода, и получить повернутую матрицу (???) - некорректное условие.

//если хотим все-таки выполнить два метода и получить просто повернутую матрицу, то нужно сделать такую лямбду:
//MatrixTransformer transformer = (x, y) -> new Coordinates (x, y); (что на самом деле довольно бессмысленная лямбда).

    }
}
