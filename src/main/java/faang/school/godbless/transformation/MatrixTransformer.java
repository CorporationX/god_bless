package faang.school.godbless.transformation;

@FunctionalInterface
interface MatrixTransformer {
    Coordinates transform(int x, int y);
}