package school.faang.bjs2_80272;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        int[][] newMatrix = TransformationManager.transformMatrix(matrix, (x, y) -> new Coordinates(y, x));
        int[][] flippedMatrix = TransformationManager.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        log.info(Arrays.deepToString(flippedMatrix));
    }
}
