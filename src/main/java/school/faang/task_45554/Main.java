package school.faang.task_45554;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] flippedMatrix = Matrix.flipMatrix(matrix, FlipDirection.VERTICAL);

        printMatrix(flippedMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            log.info("");
            for (int j = 0; j < matrix[i].length; j++) {
                log.info(String.valueOf(matrix[i][j]));
            }
        }
    }
}
