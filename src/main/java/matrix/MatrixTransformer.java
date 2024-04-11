package matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
