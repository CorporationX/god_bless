package faang.school.godbless;

import lombok.Getter;

@Getter
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Coordinates newCoords = transformer.transform(i, j);
                newMatrix[newCoords.x][newCoords.y] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
