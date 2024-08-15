package faang.school.godbless.BJS2_20498;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int countRows = matrix.length;
        int countElementsFirstRow = matrix[0].length;
        int[][] transformedMatrix = new int[countRows][countElementsFirstRow];
        for (int i = 0; i < countRows; i++) {
            for (int j = 0; j < countElementsFirstRow; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                transformedMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }
}
