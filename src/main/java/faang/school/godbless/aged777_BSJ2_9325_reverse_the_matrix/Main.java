package faang.school.godbless.aged777_BSJ2_9325_reverse_the_matrix;

import faang.school.godblessaged777_BJS2_7677_rearrange_array.Example;

public class Main {
    /*

    Условия задачи:
Представим, что перед нами стоит задача: уметь трансформировать матрицу (двумерный массив).
Мы, как умный программисты, решили написать на это функциональный интерфейс MatrixTransformer, и написать
метод transformMatrix, который его принимает, чтобы как-то преобразовать матрицу и вернуть новую.

static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer)
MatrixTransformer имеет единственный метод, который принимает два числа (индексы ячейки), и возвращает так же 2 числа.
В Java нельзя вернуть сразу 2 результата из функции, поэтому нужно написать класс Coordinates, с 2-мя полями x и y.

Написать метод, который принимает FlipDirection, и в зависимости от него переворачивает матрицу.

public enum FlipDirection {
    HORIZONTAL,
    VERTICAL,
}

static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection)

Например матрица:

1  2

3  4

При горизонтальном повороте примет вид:

2  1

4  3

     */

    private static final MatrixTransformer transformerHorizontal = (matrix) -> {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Example.reverse(matrix[i]);
        }
        return matrix;
    };
    private static final MatrixTransformer transformerVertical = (matrix) -> {
        for (int i = 0; i < matrix[0].length; i++) {
            int[] currentColumn = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                currentColumn[j] = matrix[j][i];
            }
            currentColumn = Example.reverse(currentColumn);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = currentColumn[j];
            }
        }
        return matrix;
    };

    public static void main(String[] args) {
        // matrix[i][j] = { 0, 1, 2, ... , j }
        //                { 1, 2, 3, ... , j }
        //                { 2, ...,        j }
        //                  .   .    .   .   .
        //                { i, ..., ....., j }

        int[][] matrix = {
                {0, 1, 2},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printMatrix(matrix);

        System.out.println("Horizontal flip:");
        flipMatrix(matrix, FlipDirection.HORIZONTAL);

        printMatrix(matrix);

        System.out.println("Vertical flip:");
        flipMatrix(matrix, FlipDirection.VERTICAL);

        printMatrix(matrix);
    }

    // Написать метод, который принимает FlipDirection, и в зависимости от него переворачивает матрицу.
    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) return transformMatrix(matrix, transformerHorizontal);
        else return transformMatrix(matrix, transformerVertical);
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        return transformer.transformMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
