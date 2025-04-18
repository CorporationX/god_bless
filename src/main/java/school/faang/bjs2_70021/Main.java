package school.faang.bjs2_70021;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2},
                {3, 4}
        };
        log.info("VERTICAL TRANSFORM RESULT: \n{}",
                Arrays.deepToString(TransformationExecutor.flipMatrix(matrix, FlipDirection.VERTICAL)));
        log.info("HORIZONTAL TRANSFORM RESULT: \n{}",
                Arrays.deepToString(TransformationExecutor.flipMatrix(matrix, FlipDirection.HORIZONTAL)));
    }
}