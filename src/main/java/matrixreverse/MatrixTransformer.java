package matrixreverse;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int row, int col);
}
