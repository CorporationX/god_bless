package school.faang.sprint_2.task_45578;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates map(int lineIndex, int columnIndex);
}
