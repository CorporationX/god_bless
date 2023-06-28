package faang.school.godbless.Sprint_3.RotateMatrix;

import faang.school.godbless.Sprint_3.Lambda.RotateMatrix.Application;
import org.junit.jupiter.api.Test;

import static faang.school.godbless.Sprint_3.Lambda.RotateMatrix.Application.flipMatrix;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    int[][] matrix = {{1, 2}, {3, 4}};

    @Test
    public void flipHORIZONTALTest() {
        int[][] n = flipMatrix(matrix, Application.FlipDirection.HORIZONTAL);

        assertTrue(matrix[0][0] == n[0][1] && matrix[0][1] == n[0][0] && matrix[1][0] == n[1][1] && matrix[1][1] == n[1][0]);
    }

    @Test
    public void flipVERTICALTest() {
        int[][] n = flipMatrix(matrix, Application.FlipDirection.VERTICAL);

        assertTrue(matrix[0][0] == n[1][0] && matrix[0][1] == n[1][1] && matrix[1][0] == n[0][0] && matrix[1][1] == n[0][1]);
    }
}