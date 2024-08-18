package faang.school.godbless.task20505;

@FunctionalInterface
public interface MatrixTransformer {
    public int [][] transformMatrix(int [][] array, MatrixTransformer transformer);
}
