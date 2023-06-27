package faang.school.godbless.Sprint_3.Lambda.RotateMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(Integer i, Integer j);
}
