package faang.school.godbless;

import static faang.school.godbless.Coordinates.transformMatrix;

public enum FlipDirection {
    HORIZONTAL,
    VERTICAL;

        public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection){
            MatrixTransformer transformer;
            switch (flipDirection){
                case HORIZONTAL:
                    transformer = (x,y) -> new Coordinates(x, matrix[0].length - y - 1);
                    break;
                case VERTICAL:
                    transformer = (x,y) -> new Coordinates(matrix.length - x - 1, y);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown FlipDirection: " + flipDirection);

            }
            return transformMatrix(matrix, transformer);

        }



}
