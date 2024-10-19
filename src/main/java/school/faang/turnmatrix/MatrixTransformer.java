package school.faang.turnmatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int row, int col);
}