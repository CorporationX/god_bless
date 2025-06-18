package school.faang.bjs2_80301;

import lombok.extern.slf4j.Slf4j;

import static school.faang.bjs2_80301.MatrixOperations.flipMatrix;
import static school.faang.bjs2_80301.MatrixOperations.printMatrix;

@Slf4j
public class Application {
    public static void main(String[] args) {
        int[][] original = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        log.info("Original:");
        printMatrix(original);

        log.info("Horizontal flip:");
        printMatrix(flipMatrix(original, FlipDirection.HORIZONTAL));

        log.info("Vertical flip:");
        printMatrix(flipMatrix(original, FlipDirection.VERTICAL));
    }
}
