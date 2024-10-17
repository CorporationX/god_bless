package school.faang.rotatematrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int row, int col);
}