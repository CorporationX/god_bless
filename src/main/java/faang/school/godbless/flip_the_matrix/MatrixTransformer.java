package faang.school.godbless.flip_the_matrix;

@FunctionalInterface
public interface MatrixTransformer  {

    Coordinates transform(Integer x, Integer y);
}
