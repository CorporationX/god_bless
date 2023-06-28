package faang.school.godbless.lambda_stream.transformation;

@FunctionalInterface
interface MatrixTransformer {
    Coordinates transform(int x, int y);
}