package faang.school.godbless.lambda.rotateMatrix;

public class MatrixRotater {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) throws IllegalArgumentException{
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix[0].length) {
                throw new IllegalArgumentException("���������� ������ �� �������� ��������!");
            }
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) throws IllegalArgumentException{
        if (matrix.length == 0) {
            return new int[0][0];
        }

        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        }
        else if (flipDirection.equals(FlipDirection.VERTICAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        }
        else
            throw new IllegalArgumentException("��� �������������� �������� ��� ������� ���� �������������.");
    }
}
