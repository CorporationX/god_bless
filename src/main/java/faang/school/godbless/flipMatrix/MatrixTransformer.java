package faang.school.godbless.flipMatrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(Integer x, Integer y);
}
