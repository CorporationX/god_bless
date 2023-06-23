package faang.school.godbless.sprint_3.matrix_reverse;

public class MatrixReverser {

    public static int[][] transformMatrix(int[][] massive, MatrixTransformer transformer) {
        if (massive.length == 0) {
            return new int[0][0];
        }
        int[][] newMassive = new int[massive.length][massive[0].length];

        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                Coordinates coordinates = transformer.change(i, j);
                newMassive[coordinates.getX()][coordinates.getY()] = massive[i][j];
            }
        }
        return newMassive;
    }

    public static int[][] flipMatrix(int[][] massive, FlipDirection flipDirection) {
        if (massive.length == 0) {
            return new int[0][0];
        }
        int[][] reversedMatrix = new int[massive.length][massive[0].length];
        if (flipDirection == FlipDirection.HORIZONTAL) {
            MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(x, massive[0].length - y - 1);
            reversedMatrix = transformMatrix(massive, matrixTransformer);
        } else if (flipDirection == FlipDirection.VERTICAL) {
            MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(massive.length - 1 - x, y);
            reversedMatrix = transformMatrix(massive, matrixTransformer);
        }
        return reversedMatrix;
    }
}