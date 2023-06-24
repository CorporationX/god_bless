package sprint3.lambda.matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
