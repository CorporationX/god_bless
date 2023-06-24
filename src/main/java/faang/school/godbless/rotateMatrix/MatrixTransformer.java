package faang.school.godbless.rotateMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(Integer x, Integer y);
}
