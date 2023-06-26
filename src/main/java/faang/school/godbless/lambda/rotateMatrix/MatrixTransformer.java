package faang.school.godbless.lambda.rotateMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
