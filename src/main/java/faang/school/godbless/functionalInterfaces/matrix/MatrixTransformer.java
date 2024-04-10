package faang.school.godbless.functionalInterfaces.matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(Coordinates coordinates, int matrixDimension);
}
