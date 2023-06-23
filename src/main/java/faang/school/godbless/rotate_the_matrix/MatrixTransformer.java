package faang.school.godbless.rotate_the_matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(int x, int y);
}
