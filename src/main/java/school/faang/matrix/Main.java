package school.faang.matrix;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 5}, {3, 4, 7}, {9, 8, 3}};
        printMatrix(matrix);
        printMatrix(Matrix.flipMatrix(matrix, FlipDirection.HORIZONTAL));
        printMatrix(Matrix.flipMatrix(matrix, FlipDirection.VERTICAL));
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder str = new StringBuilder("\n");
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                str.append(matrix[x][y]).append(" ");
            }
            str.append("\n");
        }
        log.info(String.valueOf(str));
    }
}

