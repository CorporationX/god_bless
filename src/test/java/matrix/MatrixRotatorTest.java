package matrix;

import faang.school.godbless.matrix.FlipDirection;
import faang.school.godbless.matrix.MatrixRotator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixRotatorTest {
  @Test
  public void flipMatrixHorizontallyTest() {
    int[][] originalMatrix = {{1,2}, {3, 4}};
    int[][] expectedHorizontalMatrix = {{2,1}, {4, 3}};
    int[][] transformedHorizontalMatrix = MatrixRotator.flipMatrix(originalMatrix, FlipDirection.HORIZONTAL);

    assertArrayEquals(expectedHorizontalMatrix, transformedHorizontalMatrix);
  }

  @Test
  public void flipMatrixVerticallyTest() {
    int[][] originalMatrix = {{1,2}, {3, 4}};
    int[][] expectedHorizontalMatrix = {{3,4}, {1, 2}};
    int[][] transformedHorizontalMatrix = MatrixRotator.flipMatrix(originalMatrix, FlipDirection.VERTICAL);

    assertArrayEquals(expectedHorizontalMatrix, transformedHorizontalMatrix);
  }
}
