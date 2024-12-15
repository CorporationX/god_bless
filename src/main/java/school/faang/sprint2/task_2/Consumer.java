package school.faang.sprint2.task_2;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T notification);
}
