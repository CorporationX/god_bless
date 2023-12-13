package faang.school.godbless.lambda.task15rotate_matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
